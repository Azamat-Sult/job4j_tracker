package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("The train rides on the rails");
    }

    @Override
    public void fillUpFuel() {
        System.out.println("The train is fueled with coal");
    }
}
