package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 7/9/13
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Launch {

    public Launch(){

        int SERVER_PORT = 8080;

        Socket clientSideSocket = null;
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;

        try{
            clientSideSocket = new Socket("localhost", SERVER_PORT);
            printWriter = new PrintWriter(clientSideSocket.getOutputStream(), true);
            bufferedReader = new BufferedReader(new InputStreamReader(clientSideSocket.getInputStream()));

            String fromServer;

            while ((fromServer = bufferedReader.readLine()) != null){
                printWriter.println("Server: " + fromServer);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Launch();
    }
}
