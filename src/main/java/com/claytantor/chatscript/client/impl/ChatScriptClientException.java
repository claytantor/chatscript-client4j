package com.claytantor.chatscript.client.impl;

/**
 * Created by claytongraham on 11/17/16.
 */
public class ChatScriptClientException extends Exception{
    public ChatScriptClientException() {
    }

    public ChatScriptClientException(String message) {
        super(message);
    }

    public ChatScriptClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChatScriptClientException(Throwable cause) {
        super(cause);
    }

    public ChatScriptClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
