package ru.job4j.professions;

public class Builder extends Engineer {

    private boolean industrialBuilder;

    public Builder() {
    }

    public Builder(String name, String surname, String education, String birthday,
                   boolean qualificationImprovement, boolean industrialBuilder) {
        super(name, surname, education, birthday, qualificationImprovement);
        this.industrialBuilder = industrialBuilder;
    }

    public void build(Material material) {
    }
}
