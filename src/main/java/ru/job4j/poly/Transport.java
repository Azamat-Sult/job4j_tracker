package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int num);

    int fillUpFuel(int amountOfFuel);
}
