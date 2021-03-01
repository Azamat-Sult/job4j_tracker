package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("The bus rides on the roads");
    }

    @Override
    public void fillUpFuel() {
        System.out.println("The bus is refueled with gasoline");
    }
}
