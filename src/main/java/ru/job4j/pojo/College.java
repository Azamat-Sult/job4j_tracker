package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Sultangareev A R");
        student.setGroup("ESiS-313");
        student.setDateOfEntrance(new Date());

        System.out.println("Student " + student.getFullName() + " studying in a group " + student.getGroup() + " since " + student.getDateOfEntrance());
    }
}
