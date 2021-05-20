package ru.job4j.stream.travel;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollect() {
        List<Address> expected = Arrays.asList(
                new Address("Шуя", "Ленина", 77, 9),
                new Address("Иваново", "Лежневская", 101, 40),
                new Address("Иваново", "10 августа", 10, 4),
                new Address("Кинешма", "Юрьевецкая", 105, 0)
        );
        List<Profile> profiles = Arrays.asList(
                new Profile(expected.get(0)),
                new Profile(expected.get(1)),
                new Profile(expected.get(2)),
                new Profile(expected.get(3))
        );
        Profiles p = new Profiles();
        List<Address> result = p.collect(profiles);
        assertThat(result, is(expected));
    }

}