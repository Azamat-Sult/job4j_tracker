package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] transport = new Vehicle[] {airplane, train, bus};
        for (int index = 0; index < transport.length; index++) {
            transport[index].fillUpFuel();
            transport[index].move();
            System.out.println();
        }
    }
}
