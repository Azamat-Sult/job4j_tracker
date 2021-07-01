package ru.job4j.leetcode;

public class ReverseString {
    public void reverseString(char[] s) {
        for (int index = 0; index < s.length / 2; index++) {
            char temp = s[index];
            s[index] = s[s.length - 1 - index];
            s[s.length - 1 - index] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseString sample = new ReverseString();
        char[] arg = new char[] {'h','e','l','l','o'};
        sample.reverseString(arg);
        for (char el : arg) {
            System.out.println(el);
        }
    }
}
