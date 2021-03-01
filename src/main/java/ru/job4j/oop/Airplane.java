package ru.job4j.oop;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("The airplane flies through the air");
    }

    @Override
    public void fillUpFuel() {
        System.out.println("The airplane is refueled with kerosene");
    }
}
