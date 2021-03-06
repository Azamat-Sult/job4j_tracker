package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionaryLambda {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> findName = person -> person.getName().equals(key);
        Predicate<Person> findSurname = person -> person.getSurname().equals(key);
        Predicate<Person> findPhone = person -> person.getPhone().equals(key);
        Predicate<Person> findAddress = person -> person.getAddress().equals(key);
        Predicate<Person> combine = findName.or(findSurname.or(findPhone.or(findAddress)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
