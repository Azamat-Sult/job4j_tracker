package ru.job4j.professions;

public class Dentist extends Doctor {

    private boolean childrenDentist;

    public Dentist() {
    }

    public Dentist(String name, String surname, String education, String birthday,
                   boolean doctoralDegree, boolean childrenDentist) {
        super(name, surname, education, birthday, doctoralDegree);
        this.childrenDentist = childrenDentist;
    }

    public void removeTooth(Pacient pacient) {
    }
}
