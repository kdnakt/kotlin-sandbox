package com.kdnakt.java;

public class MyObject {
    private String name;
    private String value;
    public MyObject(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}