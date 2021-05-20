package ru.job4j.stream.travel;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
        return
            profiles.stream()
            .map(p -> p.getAddress())
            .sorted((a1, a2) -> a1.getCity().compareTo(a2.getCity()))
            .distinct()
            .collect(Collectors.toList());
    }
}
