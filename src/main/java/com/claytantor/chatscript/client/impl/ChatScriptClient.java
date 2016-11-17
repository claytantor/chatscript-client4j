package com.claytantor.chatscript.client.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by claytongraham on 11/17/16.
 */
public class ChatScriptClient {

    public String hostName;
    public int portNumber;
    public String clientId;
    public String robotName;

    public ChatScriptClient(String hostName, int portNumber, String clientId, String robotName) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.clientId = clientId;
        this.robotName = robotName;
    }

    public String send(String message) throws ChatScriptClientException {

        try {

            StringBuffer buf = new StringBuffer();
            Socket chatscriptSocket = new Socket(hostName, portNumber);
            DataOutputStream os = new DataOutputStream(chatscriptSocket.getOutputStream());
            DataInputStream is = new DataInputStream(chatscriptSocket.getInputStream());

            os.writeBytes(String.format("%s\u0000%s\u0000%s\u0000", clientId, robotName, message));
            String responseLine;
            while ((responseLine = is.readLine()) != null) {
                buf.append(responseLine);
            }

            is.close();
            os.close();
            chatscriptSocket.close();
            return buf.toString();

        } catch (UnknownHostException e) {
            throw new ChatScriptClientException(e);
        } catch (IOException e) {
            throw new ChatScriptClientException(e);
        }

    }




}
