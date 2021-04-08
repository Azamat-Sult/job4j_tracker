package ru.job4j.professions;

public class Engineer extends Profession {

    private boolean qualificationImprovement;

    public Engineer() {
    }

    public Engineer(String name, String surname, String education, String birthday,
                    boolean qualificationImprovement) {
        super(name, surname, education, birthday);
        this.qualificationImprovement = qualificationImprovement;
    }

    public Product create(Material material) {
        Product item = new Product();
        return item;
    }
}
