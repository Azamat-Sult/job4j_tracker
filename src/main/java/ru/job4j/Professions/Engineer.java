package ru.job4j.Professions;

public class Engineer extends Profession {

    private boolean qualificationImprovement;

    public Engineer() {
    }

    public Engineer(boolean qualificationImprovement) {
        this.qualificationImprovement = qualificationImprovement;
    }

    public Product create(Material material) {
        Product item = new Product();
        return item;
    }
}
