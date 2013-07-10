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

    public static int[] promptUser(){

        String userInput;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter two numbers, separated by a comma (2,2): ");
        userInput = scanner.nextLine();

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

            int SERVER_PORT = 30000;

            Socket clientSideSocket = null;
            PrintWriter out = null;
            BufferedReader bufferedReader = null;

            clientSideSocket = new Socket("localhost", SERVER_PORT);
            out = new PrintWriter(clientSideSocket.getOutputStream(), true);
            bufferedReader = new BufferedReader(new InputStreamReader(clientSideSocket.getInputStream()));

            int[] values = promptUser();

            out.println(values[0]);
            out.println(values[1]);

            String fromServer;

            while ((fromServer = bufferedReader.readLine()) != null)
                System.out.println("Server: " + fromServer);

            out.flush();

            out.close();
            bufferedReader.close();
            clientSideSocket.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
