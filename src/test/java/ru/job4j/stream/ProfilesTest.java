package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void collectCorrect() {
        Profiles tourAgency = new Profiles();
        Address adr1 = new Address();
        Address adr2 = new Address();
        Address adr3 = new Address();
        List<Address> allAdr = List.of(adr1, adr2, adr3);
        List<Profile> profiles = List.of(new Profile(adr1), new Profile(adr2), new Profile(adr3));
        assertThat(allAdr, is(tourAgency.collect(profiles)));
    }
}