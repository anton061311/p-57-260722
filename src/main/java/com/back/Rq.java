package com.back;

public class Rq {
     private final String command;

    public Rq(String command) {
        this.command = command;
    }

    public String getActionName() {
        return command.split("\\?")[0];
    }
    public String getParam(String key, String value) {
        return "홍길동";
    }
}
