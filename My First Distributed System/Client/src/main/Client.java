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

    public static String promptUser(String message) throws IOException{

        String userInput;

        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        userInput = scanner.nextLine();

        return userInput;
    }

    public static void printResponse(BufferedReader bufferedReader) throws IOException{

        String fromServer = bufferedReader.readLine();
        System.out.println("Server: " + fromServer);
    }

    public static void writeLine(PrintWriter out, String message){

        out.println(message);
        out.flush();
    }

    public static void main(String[] args){
        try{
            int SERVER_PORT = 8080;

            Socket clientSideSocket = new Socket("localhost", SERVER_PORT);
            PrintWriter out = new PrintWriter(clientSideSocket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSideSocket.getInputStream()));

            String operation = promptUser("Addition or Subtraction? : ");
            writeLine(out, operation.toLowerCase());
            printResponse(bufferedReader);

            String shortOperation = operation.equalsIgnoreCase("addition")? "add" : "subtract";

            String firstValue = promptUser("First number to " + shortOperation);
            writeLine(out, firstValue);
            printResponse(bufferedReader);

            String secondValue = promptUser("Second number to " + shortOperation);
            writeLine(out, secondValue);
            printResponse(bufferedReader);

            bufferedReader.close();
            out.flush();
            out.close();
            clientSideSocket.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
