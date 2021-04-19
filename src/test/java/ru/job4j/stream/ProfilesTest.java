package ru.job4j.stream;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void collectCorrect() {
        Profiles tourAgency = new Profiles();
        Address adr1 = new Address("Москва", "Мира", 164, 22);
        Address adr2 = new Address("Уфа", "Гагарина", 16, 68);
        Address adr3 = new Address("Сочи", "Набережная", 11, 6);
        List<Address> allAdr = List.of(adr1, adr2, adr3);
        List<Profile> profiles = List.of(new Profile(adr1), new Profile(adr2), new Profile(adr3));
        assertThat(allAdr, is(tourAgency.collect(profiles)));
    }

    @Test
    public void sortingByCityUnique() {
        Profiles tourAgency = new Profiles();
        Address adr1 = new Address("Ялта", "Мира", 164, 22);
        Address adr2 = new Address("Воронеж", "Гагарина", 16, 68);
        Address adr3 = new Address("Брянск", "Набережная", 11, 6);
        Address adr4 = new Address("Адлер", "Гончарова", 124, 2);
        Address adr5 = new Address("Адлер", "Гончарова", 124, 2);
        Address adr6 = new Address("Воронеж", "Гагарина", 16, 68);
        List<Address> expectAdr = List.of(adr4, adr3, adr2, adr1);
        List<Profile> profiles = List.of(new Profile(adr1), new Profile(adr2),
                new Profile(adr3), new Profile(adr4), new Profile(adr5), new Profile(adr6));
        assertThat(expectAdr, is(tourAgency.collectUnique(profiles)));
    }
}
