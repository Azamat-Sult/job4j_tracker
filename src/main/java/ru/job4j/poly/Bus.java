package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Lets GO!");
    }

    @Override
    public void passengers(int num) {
        System.out.println(num + " passengers boarded the bus");
    }

    @Override
    public int fillUpFuel(int amountOfFuel) {
        int gallonCost = 100;
        return gallonCost * amountOfFuel;
    }
}
