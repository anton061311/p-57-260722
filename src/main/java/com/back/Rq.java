package com.back;

public class Rq {
     private final String command;

    public Rq(String command) {
        this.command = command;
    }

    public String getActionName() {
        return command.split("\\?")[0];
    }


    public String getParam(String inputKey, String inputValue) {
        String[] commandTokens = command.split("\\?");
        String queryString = commandTokens[1];
        String[] queryTokens = queryString.split("&");

        for (String param : queryTokens){
            String[] paramTokens = param.split("=");
            String key = paramTokens[0];
            String value = paramTokens[1];

            if(inputKey.equals(key)) return value;
        }

        return inputValue;
    }
}
