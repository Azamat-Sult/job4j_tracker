package ru.job4j.Professions;

public class Programmer extends Engineer {

    private boolean gameDeveloper;

    public Programmer() {
    }

    public Programmer(String name, String surname, String education, String birthday, boolean qualificationImprovement, boolean gameDeveloper) {
        super(name, surname, education, birthday, qualificationImprovement);
        this.gameDeveloper = gameDeveloper;
    }

    public void deBug(Product product) {
    }
}
