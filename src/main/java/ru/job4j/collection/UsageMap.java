package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mailAndName = new HashMap<>();
        mailAndName.put("parsentev@yandex.ru", "Petr Arsentev");
        mailAndName.put("investor_micex@mail.ru", "Azamat Sultangareev");
        for (String key : mailAndName.keySet()) {
            System.out.println(key + " " + mailAndName.get(key));
        }
    }
}
