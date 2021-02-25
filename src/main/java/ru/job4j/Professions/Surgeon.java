package ru.job4j.Professions;

public class Surgeon extends Doctor {

    private boolean cardio;

    public Surgeon() {
    }

    public Surgeon(boolean cardio) {
        this.cardio = cardio;
    }

    public void operate(Pacient pacient) {
    }
}
