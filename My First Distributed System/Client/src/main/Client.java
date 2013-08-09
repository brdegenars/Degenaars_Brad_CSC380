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

    private static String[] availableMethods;
    private static String[] availableClasses;
    private static String operation;

    protected static String promptUser(String message) throws IOException{

        String userInput;

        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        userInput = scanner.nextLine();

        return userInput;
    }

    protected static void printResponse(BufferedReader bufferedReader) throws IOException{

        String fromServer = bufferedReader.readLine();
        System.out.println("Server: " + fromServer);
    }

    protected static void writeLine(PrintWriter out, String message){

        out.println(message);
        out.flush();
    }

    protected static boolean validateMethodCall(String methodToInvoke){

        boolean validMethod = false;

        String[] methodParts = methodToInvoke.split("\\(");
        String methodName = methodParts[0];
        operation = methodName;
        String methodParametersWhole = methodParts[1].substring(0, (methodParts[1].length()-1));
        String[] methodParametersParts = methodParametersWhole.split(",");

        for(String methodSignature : availableMethods){

            String[] currentMethodParts = methodSignature.split("\\(");
            String currentMethodName = currentMethodParts[0];
            String[] currentMethodParameterTypes = currentMethodParts[1].substring(0, (currentMethodParts[1].length()-1)).split(",");

            if (methodName.equalsIgnoreCase(currentMethodName)){
                validMethod = true;
            }
        }
        return validMethod;
    }

    public static void main(String[] args){

        try{
            int SERVER_PORT = 8080;
            boolean validMethod, wantsToQuit = false;

            Socket clientSideSocket = new Socket("localhost", SERVER_PORT);
            PrintWriter out = new PrintWriter(clientSideSocket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSideSocket.getInputStream()));

            do {
                System.out.println("The following classes are available to invoke: ");

                if(availableClasses == null){
                    String serverResponse = bufferedReader.readLine();
                    availableClasses = serverResponse.split("//");
                }

                for(String className : availableClasses){
                    System.out.println(className.split("\\.")[1]);
                }
                String classToLoad = promptUser("Which class would you like an instance of? (Type 'Q' to quit)\n:");

                if (classToLoad.equalsIgnoreCase("q")){
                    wantsToQuit = true;
                    break;
                }

                writeLine(out, classToLoad);

                do {
                    System.out.println("The follow methods are available: ");
                    if (availableMethods == null){
                        String serverResponse = bufferedReader.readLine();
                        availableMethods = serverResponse.split("//");
                    }

                    for(String methodSignature : availableMethods){
                        System.out.println(methodSignature.split("\\(")[0] + "()");
                    }
                    System.out.println();

                    String methodToInvoke = promptUser("Which method would you like to call?\nExample: add(2,2) or subtract(10,2,4)\n(Type 'Q' to quit): ");
                    if (methodToInvoke.equalsIgnoreCase("q")){
                        out.println(methodToInvoke);
                        System.out.println(bufferedReader.readLine());
                        wantsToQuit = true;
                        break;
                    }
                    validMethod = validateMethodCall(methodToInvoke);
                    if(validMethod){
                        writeLine(out, methodToInvoke);
                        printResponse(bufferedReader);
                    }
                } while (validMethod);
            } while (!wantsToQuit);

            bufferedReader.close();
            out.flush();
            out.close();
            clientSideSocket.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
