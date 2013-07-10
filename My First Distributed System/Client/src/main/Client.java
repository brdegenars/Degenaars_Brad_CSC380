package main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 7/9/13
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    public static int[] promptUser() throws IOException{

        String userInput;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter two numbers, separated by a comma (2,2): ");
        userInput = reader.readLine();

        reader.close();

        return extractValues(userInput);
    }

    public static int[] extractValues(String input){

        int a, b;

        input = input.trim();

        a = Integer.parseInt(input.substring(0,1));
        b = Integer.parseInt(input.substring(2));

        return new int[]{a,b};
    }

    public static void main(String[] args){
        try{

            int SERVER_PORT = 8080;

            Socket clientSideSocket = null;
            PrintWriter out = null;
            BufferedReader bufferedReader = null;

            clientSideSocket = new Socket("localhost", SERVER_PORT);
            out = new PrintWriter(clientSideSocket.getOutputStream(), true);

            int[] values = promptUser();

            for(int value : values)
                out.println(value);

            bufferedReader = new BufferedReader(new InputStreamReader(clientSideSocket.getInputStream()));

            String fromServer;

            while ((fromServer = bufferedReader.readLine()) != null)
                System.out.println("Server: " + fromServer);

            bufferedReader.close();
            out.flush();
            out.close();
            clientSideSocket.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
