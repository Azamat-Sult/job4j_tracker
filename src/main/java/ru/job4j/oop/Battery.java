package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int initLoad) {
        this.load = initLoad;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battOne = new Battery(25);
        Battery battTwo = new Battery(75);
        System.out.println("Current battOne load: " + battOne.load);
        System.out.println("Current battTwo load: " + battTwo.load);
        battOne.exchange(battTwo);
        System.out.println("Current battOne load: " + battOne.load);
        System.out.println("Current battTwo load: " + battTwo.load);
    }
}
