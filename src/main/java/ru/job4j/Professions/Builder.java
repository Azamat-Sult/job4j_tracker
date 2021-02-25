package ru.job4j.Professions;

public class Builder extends Engineer {

    private boolean industrialBuilder;

    public Builder() {
    }

    public Builder(boolean industrialBuilder) {
        this.industrialBuilder = industrialBuilder;
    }

    public void build(Material material) {
    }
}
