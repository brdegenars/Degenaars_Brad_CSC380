package main;

import math.MathLogic;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
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

    private static final String OK_MESSAGE = "OK.";
    private static final String BAD_MESSAGE = "BAD.";

    @SuppressWarnings("unchecked")
    public Server(int serverPort){
        try{

            ServerSocket serverSocket = null;

            try{
                serverSocket = new ServerSocket(serverPort);
            } catch (Exception e){
                System.out.println("Couldn't listen on " + serverPort);
            }

            Socket clientSocket = null;

            if (serverSocket != null)
                clientSocket = serverSocket.accept();

            if (clientSocket != null){

                BufferedReader bufferedReader;
                PrintWriter out;

                out = new PrintWriter(clientSocket.getOutputStream());
                bufferedReader  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String userInput;
                List<String> methodSignatures = getMethodSignatures(MathLogic.class);
                List<String> methodNames = new ArrayList<String>();

                StringBuilder response = new StringBuilder();
                for (String currentSignature : methodSignatures) {
                    methodNames.add(currentSignature.split("\\(")[0]);
                    response.append(currentSignature);
                    response.append("//");
                }
                writeLine(out, response.toString());
                response.delete(0, response.length());

                do {
                    userInput = bufferedReader.readLine();
                    if (userInput.equalsIgnoreCase("q")){
                        writeLine(out, OK_MESSAGE);
                        break;
                    }
                    String[] userMethodParts = userInput.split("\\(");
                    boolean foundMethod = false;
                    for (String methodName : methodNames) {
                        String userMethodName = userMethodParts[0];
                        if (userMethodName.equalsIgnoreCase(methodName)){
                            Object[] serverMethodParameters = userMethodParts[1].split(",");
                            String lastParam = (String)serverMethodParameters[serverMethodParameters.length - 1];
                            lastParam = lastParam.substring(0, lastParam.length() - 1);
                            serverMethodParameters[serverMethodParameters.length - 1] = lastParam;
                            try{
                                Class mathLogic = Class.forName(MathLogic.class.getName());
                                Object matLog = mathLogic.newInstance();

                                Method methodToInvoke = mathLogic.getMethod(methodName, Object[].class);
                                int result = (Integer)methodToInvoke.invoke(matLog, new Object[] {serverMethodParameters});
                                response.append(result);

                            } catch (NoSuchMethodException e){
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            }
                            foundMethod = true;
                            writeLine(out, response.toString());
                            response.delete(0, response.length());
                            break;
                        }
                    }
                    if (!foundMethod)
                        writeLine(out, BAD_MESSAGE);

                    out.flush();
                } while(true);

                out.close();
                clientSocket.close();
                serverSocket.close();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    protected static void writeLine(PrintWriter out, String message){

        out.println(message);
        out.flush();
    }

    protected List<String> getMethodSignatures(Class currentClass){

        Method[] methods = currentClass.getDeclaredMethods();

        List<String> methodSignatures = new ArrayList<String>();
        StringBuilder signatureBuilder = new StringBuilder();

        for (Method currentMethod : methods) {
            signatureBuilder.append(currentMethod.getName());
            signatureBuilder.append("(");

            Type[] parameterTypes = currentMethod.getGenericParameterTypes();

            for (int j = 0; j < parameterTypes.length; j++) {
                signatureBuilder.append(parameterTypes[j]);
                if (j != parameterTypes.length - 1)
                    signatureBuilder.append(", ");
            }

            signatureBuilder.append(")");
            methodSignatures.add(signatureBuilder.toString());
            signatureBuilder.delete(0, signatureBuilder.length());
        }
        return methodSignatures;
    }

    public static void main(String[] args){
        new Server(8080);
    }
}
