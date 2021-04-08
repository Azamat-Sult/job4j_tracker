package ru.job4j.professions;

public class Surgeon extends Doctor {

    private boolean cardio;

    public Surgeon() {
    }

    public Surgeon(String name, String surname, String education, String birthday,
                   boolean doctoralDegree, boolean cardio) {
        super(name, surname, education, birthday, doctoralDegree);
        this.cardio = cardio;
    }

    public void operate(Pacient pacient) {
    }
}
