package ru.job4j.collection;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons;

    public PhoneDictionary() {
        persons = new ArrayList<>();
    }

    public void add(Person value) {
        persons.add(value);
    }

    /**
     * Вернуть список всех пользователей, которые содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> nameContainsKey = (p) -> p.getName().contains(key);
        Predicate<Person> surnameContainsKey = (p) -> p.getSurname().contains(key);
        Predicate<Person> phoneContainsKey = (p) -> p.getPhone().contains(key);
        Predicate<Person> addressContainsKey = (p) -> p.getAddress().contains(key);
        Predicate<Person> combine = (p) ->
                nameContainsKey
                .or(surnameContainsKey)
                .or(phoneContainsKey)
                .or(addressContainsKey)
                .test(p);
        for (Person entry : persons) {
            if (combine.test(entry)) {
                result.add(entry);
            }
        }
        return result;
    }
}