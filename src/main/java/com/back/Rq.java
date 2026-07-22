package com.back;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Rq {
     private final String command;

    public Rq(String command) {
        this.command = command;
    }

    public String getActionName() {
        return command.split("\\?")[0];
    }


    public String getParam(String inputKey, String inputValue) {

        Map<String, String> paramMap = new HashMap<>();

        String[] commandTokens = command.split("\\?");
        String queryString = commandTokens[1];
        String[] queryTokens = queryString.split("&");

        paramMap = Arrays.stream(queryTokens)
                .map(param -> param.split("="))
                .collect(
                        Collectors.toMap(
                                tokens -> tokens[0],
                                tokens -> tokens[1]
                        )
                );

        return paramMap.getOrDefault(inputKey, inputValue);
    }

    public int getParamAsInt(String inputKey, int inputValue){
        return inputValue;

//        String value = getParam(key, "");
//
//        if(value.isBlank()) {
//            return inputValue;
//        }
//
//        return Integer.parseInt(value);
    }
}
