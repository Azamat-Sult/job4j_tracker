package ru.job4j.stream;

public class PersonalComputer {
    private String computerCase;
    private String motherBoard;
    private String processor;
    private String powerSupply;
    private int ram;
    private String hdd;
    private String cooler;

    @Override
    public String toString() {
        return "PersonalComputer{"
                + "computerCase='" + computerCase + '\''
                + ", motherBoard='" + motherBoard + '\''
                + ", processor='" + processor + '\''
                + ", powerSupply='" + powerSupply + '\''
                + ", ram=" + ram + ", hdd='" + hdd + '\''
                + ", cooler='" + cooler + '\'' + '}';
    }

    static class Builder {
        private String computerCase;
        private String motherBoard;
        private String processor;
        private String powerSupply;
        private int ram;
        private String hdd;
        private String cooler;

        Builder buildComputerCase(String computerCase) {
            this.computerCase = computerCase;
            return this;
        }

        Builder buildMotherBoard(String motherBoard) {
            this.motherBoard = motherBoard;
            return this;
        }

        Builder buildProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        Builder buildPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        Builder buildRAM(int ram) {
            this.ram = ram;
            return this;
        }

        Builder buildHDD(String hdd) {
            this.hdd = hdd;
            return this;
        }

        Builder buildCooler(String cooler) {
            this.cooler = cooler;
            return this;
        }

        PersonalComputer build() {
            PersonalComputer pc = new PersonalComputer();
            pc.computerCase = computerCase;
            pc.motherBoard = motherBoard;
            pc.processor = processor;
            pc.powerSupply = powerSupply;
            pc.ram = ram;
            pc.hdd = hdd;
            pc.cooler = cooler;
            return pc;
        }
    }

    public static void main(String[] args) {
        PersonalComputer newPC = new Builder()
                .buildComputerCase("InWin")
                .buildMotherBoard("ASUS")
                .buildProcessor("Intel")
                .buildPowerSupply("Corsair")
                .buildRAM(16)
                .buildHDD("Samsung Barracuda")
                .buildCooler("Zalman")
                .build();
        System.out.println(newPC);
    }
}
