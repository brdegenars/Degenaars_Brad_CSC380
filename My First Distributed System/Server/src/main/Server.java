package main;

import math.MathLogic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 7/9/13
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Server {

    public static void main(String[] args){
        try{

            ServerSocket serverSocket = null;
            int SERVER_PORT = 30000;

            try{
                serverSocket = new ServerSocket(SERVER_PORT);
            } catch (Exception e){
                System.out.println("Couldn't listen on " + SERVER_PORT);
            }

            Socket clientSocket = null;

            if (serverSocket != null)
                clientSocket = serverSocket.accept();

            if (clientSocket != null){

                OutputStream out = null;
                InputStream inputStream = null;

                BufferedReader bufferedReader;
                List<String> valuesReceived = null;

                inputStream = clientSocket.getInputStream();
                out = clientSocket.getOutputStream();

                bufferedReader  = new BufferedReader(new InputStreamReader(inputStream));
                valuesReceived = new ArrayList<String>();

                String input;

                while ((input = bufferedReader.readLine()) != null)
                    valuesReceived.add(input);

                int sum, difference;

                if (!valuesReceived.isEmpty()){
                    int a = Integer.parseInt(valuesReceived.get(0));
                    int b = Integer.parseInt(valuesReceived.get(1));

                    sum = MathLogic.add(a, b);
                    difference = MathLogic.subtract(a, b);

                    System.out.println("Value 1: " + a);
                    System.out.println("Value 2: " + b + "\n");
                    System.out.println("Sum: " + sum);
                    System.out.println("Difference: " + difference);

                    byte[] returnMessage = ("Sum: " + sum).getBytes();
                    out.write(returnMessage, 0, returnMessage.length);

                    returnMessage = ("Difference: " + difference).getBytes();
                    out.write(returnMessage, 0, returnMessage.length);
                }

                out.flush();
                out.close();
                inputStream.close();
                clientSocket.close();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}