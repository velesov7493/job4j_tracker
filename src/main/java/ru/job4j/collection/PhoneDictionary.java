package ru.job4j.collection;

import java.util.ArrayList;

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
        for (Person entry : persons) {
            if (
                    entry.getName().contains(key)
                    || entry.getSurname().contains(key)
                    || entry.getPhone().contains(key)
                    || entry.getAddress().contains(key)
            ) {
                result.add(entry);
            }
        }
        return result;
    }
}
