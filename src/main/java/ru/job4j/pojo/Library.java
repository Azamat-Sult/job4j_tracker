package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Java", 1500);
        Book book2 = new Book("C++", 2000);
        Book book3 = new Book("PHP", 1000);
        Book book4 = new Book("BASIC", 500);
        Book book5 = new Book("Clean code", 1300);
        Book[] lib = new Book[5];
        lib[0] = book1;
        lib[1] = book2;
        lib[2] = book3;
        lib[3] = book4;
        lib[4] = book5;
        for (int index = 0; index < lib.length; index++) {
            Book bk = lib[index];
            System.out.println(bk.getName() + " - " + bk.getNumberOfPages() + " pages");
        }
        System.out.println("--------------------------------------------------------");
        Book temp = new Book();
        temp = lib[0];
        lib[0] = lib[3];
        lib[3] = temp;
        for (int index = 0; index < lib.length; index++) {
            Book bk = lib[index];
            System.out.println(bk.getName() + " - " + bk.getNumberOfPages() + " pages");
        }
        System.out.println("--------------------------------------------------------");
        for (int index = 0; index < lib.length; index++) {
            Book bk = lib[index];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getNumberOfPages() + " pages");
            }
        }
    }
}
