package ru.job4j.Professions;

public class Engineer extends Profession {

    private boolean qualificationImprovement = false;

    public Product create(Material material) {
        Product item = new Product();
        return item;
    }
}
