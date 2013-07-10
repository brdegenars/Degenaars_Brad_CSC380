package main;

import math.SimpleMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 7/9/13
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Launch {

    public Launch(){

        ServerSocket serverSocket = null;

        int SERVER_PORT = 8080;
        try{
            serverSocket = new ServerSocket(SERVER_PORT);
        } catch (Exception e){
            System.out.println("Couldn't listen on " + SERVER_PORT);
        }

        Socket clientSocket = null;

        if (serverSocket != null){
            try{
                clientSocket = serverSocket.accept();
            } catch (IOException e){
                System.out.println("Server acceptance failed");
            }
        }

        PrintWriter out = null;

        if (clientSocket != null){

            BufferedReader bufferedReader;

            try{
                bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        int[] results = promptUser();

        if (out != null){
            out.println("Sum : " + results[0]);
            out.println("Difference : " + results[1]);
        }
    }

    public int[] promptUser(){

        String userInput;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter two numbers, seperated by a comma (2,2): ");
        userInput = scanner.nextLine();

        int[] values = extractValues(userInput);

        int sum, difference;

        sum = SimpleMath.add(values[0], values[1]);
        difference = SimpleMath.subtract(values[0], values[1]);

        return new int[]{sum, difference};
    }

    public int[] extractValues(String input){

        int a, b;

        input = input.trim();

        a = Integer.parseInt(input.substring(0,1));
        b = Integer.parseInt(input.substring(2));

        return new int[]{a,b};
    }

    public static void main(String[] args){
        new Launch();
    }
}
