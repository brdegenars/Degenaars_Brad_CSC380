package main;

import math.MathLogic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 7/9/13
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Server {

    private static final String OK_MESSAGE = "OK.";

    public static void writeLine(PrintWriter out, String message){

        out.println(message);
        out.flush();
    }

    public static void main(String[] args){
        try{

            ServerSocket serverSocket = null;
            int SERVER_PORT = 8080;

            try{
                serverSocket = new ServerSocket(SERVER_PORT);
            } catch (Exception e){
                System.out.println("Couldn't listen on " + SERVER_PORT);
            }

            Socket clientSocket = null;

            if (serverSocket != null)
                clientSocket = serverSocket.accept();

            if (clientSocket != null){

                BufferedReader bufferedReader;
                PrintWriter out;

                out = new PrintWriter(clientSocket.getOutputStream());
                bufferedReader  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String operation = bufferedReader.readLine();
                writeLine(out, OK_MESSAGE);

                String firstValue = bufferedReader.readLine();
                writeLine(out, OK_MESSAGE);

                String secondValue = bufferedReader.readLine();

//                if (!valuesReceived.isEmpty()){
                    int a = Integer.parseInt(firstValue);
                    int b = Integer.parseInt(secondValue);

                    System.out.println("Value 1: " + a);
                    System.out.println("Value 2: " + b + "\n");

                    if(operation.equalsIgnoreCase("addition")){
                        int sum = MathLogic.add(a, b);
                        System.out.println("Sum: " + sum);
                        writeLine(out, firstValue + " + " + secondValue + " = " + sum);
                    } else {
                        int difference = MathLogic.subtract(a, b);
                        System.out.println("Difference: " + difference);
                        writeLine(out, firstValue + " - " + secondValue + " = " + difference);
                    }
//                }

                out.flush();
                out.close();
                clientSocket.close();
                serverSocket.close();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
