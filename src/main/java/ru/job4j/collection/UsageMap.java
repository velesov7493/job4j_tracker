package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        Map<String, String> users = new HashMap<>();
        users.put("ivanov3217@yandex.ru", "Иванов Иван Иванович");
        users.put("jim@gmail.com", "Jimmy Lee");
        users.put("sidorov386757@mail.ru", "Сидоров Василий Иванович");
        for (String key : users.keySet()) {
            System.out.println(key + " : " + users.get(key));
        }
    }
}
