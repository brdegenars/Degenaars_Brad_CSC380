package main;

import math.IMath;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
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
                List<Class<IMath>> classesInMathPackage = null;
                try {
                     classesInMathPackage = getClassesInPackage("math");
                } catch (ClassNotFoundException e) {
                    writeLine(out, "Sorry, couldn't find any classes in the math package.");
                    System.exit(-1);
                }
                StringBuilder firstResponse = new StringBuilder();

                for(Class<IMath> mathClass : classesInMathPackage){
                    firstResponse.append(mathClass.getName().replaceAll(".class", ""));
                    firstResponse.append("//");
                }

                boolean classExists = true;

                do{
                    writeLine(out, firstResponse.toString());

                    userInput = bufferedReader.readLine();
                    Class desiredClass = null;

                    for(Class mathClass: classesInMathPackage){
                        String mathClassShortName = (mathClass.getName().replaceAll(".class", "")).split("\\.")[1];
                        if(userInput.equals(mathClassShortName)){
                            desiredClass = mathClass;
                            break;
                        }
                    }

                    List<String> methodSignatures = getMethodSignatures(desiredClass);
                    List<String> methodNames = new ArrayList<String>();

                    if(methodSignatures != null){

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
                                    String desiredClassName = desiredClass.getName();
                                    try{
                                        Class mathLogic = Class.forName(desiredClassName);
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
                    } else {
                        classExists = false;
                    }
                } while (!classExists);

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

    @SuppressWarnings("unchecked")
    protected List<Class<IMath>> getClassesInPackage(String packageName) throws ClassNotFoundException{

        List<String> classNames = new ArrayList<String>();
        List<Class<IMath>> mathClasses = new ArrayList<Class<IMath>>();

        URL rootDirectory = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));

        File[] classes = getFilesOfType(rootDirectory, ".class");

        for(File mathClass : classes){
            String className = mathClass.getName().replaceAll(".class", "");
            Class<IMath> iMathClass = (Class<IMath>)Class.forName("math." + className);
            if (IMath.class.isAssignableFrom(iMathClass));
                mathClasses.add(iMathClass);
        }

        return mathClasses;
    }

    protected File[] getFilesOfType(URL rootDirectory, final String fileType){

        File file = null;
        try {
            file = new File(URLDecoder.decode(rootDirectory.getFile(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        File[] files = null;
        if (file != null) {
            files = file.listFiles(
                    new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.endsWith(".class");
                        }
                    }
            );
        }
        return files;
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
