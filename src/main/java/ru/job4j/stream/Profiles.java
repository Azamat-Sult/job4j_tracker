package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public List<Address> collectUnique(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted((a1, a2) -> a1.getCity().compareTo(a2.getCity()))
                .distinct()
                .collect(Collectors.toList());
    }
}
