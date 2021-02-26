package ru.job4j.Professions;

public class Doctor extends Profession {

    private boolean doctoralDegree;

    public Doctor() {
    }

    public Doctor(String name, String surname, String education, String birthday, boolean doctoralDegree) {
        super(name, surname, education, birthday);
        this.doctoralDegree = doctoralDegree;
    }

    public Diagnosis heal(Pacient pacient) {
        Diagnosis diag = new Diagnosis();
        return diag;
    }
}
