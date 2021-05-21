package ru.job4j.stream.travel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
        return
            profiles.stream()
            .map(p -> p.getAddress())
            .sorted(Comparator.comparing(Address::getCity))
            .distinct()
            .collect(Collectors.toList());
    }
}
