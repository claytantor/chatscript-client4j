package com.claytantor.chatscript.client.app;

import com.claytantor.chatscript.client.impl.ChatScriptClient;
import com.claytantor.chatscript.client.impl.ChatScriptClientException;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by claytongraham on 11/16/16.
 */
public class ChatScriptClientApp {

    public static void main(String[] args){

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        String user = args[2];
        String robotName = args[3];

        //make the client
        ChatScriptClient client = new ChatScriptClient(hostName,portNumber,user,robotName);

        System.out.println("Lets start chatting "+user+"!");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String input = null;
            System.out.print(">");
            while((input = br.readLine()) != null){
                if(input.equals("."))
                    break;
                System.out.println(user+": "+input);
                System.out.println(robotName+": " + client.send(input));
                System.out.print(">");

            }
            System.out.println("done.");

        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        } catch (ChatScriptClientException e) {
            System.err.println("ChatScriptClientException:  " + e);
        }
    }

}
