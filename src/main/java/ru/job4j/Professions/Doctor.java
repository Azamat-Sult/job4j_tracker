package ru.job4j.Professions;

public class Doctor extends Profession {

    private boolean doctoralDegree;

    public Doctor() {
    }

    public Doctor(boolean doctoralDegree) {
        this.doctoralDegree = doctoralDegree;
    }

    public Diagnosis heal(Pacient pacient) {
        Diagnosis diag = new Diagnosis();
        return diag;
    }
}
