package com.claytantor.chatscript.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by claytongraham on 11/16/16.
 */
public class ChatScriptClient {

    public static void main(String[] args){

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        String user = args[2];
        String robotName = args[3];
        System.out.println("Lets start chatting "+user+"!");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String input = null;
            System.out.print(">");
            while((input = br.readLine()) != null){
                if(input.equals("."))
                    break;
                System.out.println(input);

                Socket chatscriptSocket = new Socket(hostName, portNumber);
                DataOutputStream os = new DataOutputStream(chatscriptSocket.getOutputStream());
                DataInputStream is = new DataInputStream(chatscriptSocket.getInputStream());

                os.writeBytes(String.format("%s\u0000%s\u0000%s\u0000",user,robotName, input));
                String responseLine;
                while ((responseLine = is.readLine()) != null) {
                    System.out.println(robotName+": " + responseLine);
                }

                is.close();
                os.close();
                chatscriptSocket.close();
                System.out.print(">");

            }
            System.out.println("done.");

        } catch (UnknownHostException e) {
            System.err.println("Trying to connect to unknown host: " + e);
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
    }

}
