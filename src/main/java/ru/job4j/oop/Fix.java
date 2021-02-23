package ru.job4j.oop;

public class Fix {

    private String desc;

    public Fix(String text) {
        this.desc = text;
    }

    public static void main(String[] args) {
        String txt = "Hello constructor";
        Fix item = new Fix(txt);
    }
}
