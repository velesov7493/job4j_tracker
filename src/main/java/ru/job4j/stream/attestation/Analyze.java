package ru.job4j.stream.attestation;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    /**
     * Вычисляет общий средний балл
     * @param stream поток учеников
     * @return общий средний балл
     */
    public static double averageScore(Stream<Pupil> stream) {
        return
                stream.flatMap(p -> p.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Вычисляет средний балл ученика по его предметам.
     * @param stream поток учеников
     * @return список из объекта Tuple (имя ученика и средний балл).
     */
    public static List<Tuple> averageScoreBySubjects(Stream<Pupil> stream) {
        return
                stream.map(
                        p -> new Tuple(
                            p.getName(),
                            p.getSubjects().stream()
                                .mapToInt(Subject::getScore)
                                .average()
                                .orElse(0D)
                        )
                )
                .collect(Collectors.toList());
    }

    /**
     * Вычисляет средний балл по всем предметам для каждого ученика.
     * @param stream поток учеников
     * @return список из объектов Tuple (название предмета и средний балл).
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return
                stream.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)
                ))
                .entrySet().stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Возвращает лучшего ученика.
     * Лучшим считается ученик с наибольшим баллом по всем предметам.
     * @param stream поток учеников
     * @return лучший ученик или null
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return
                stream.map(
                        p -> new Tuple(
                                p.getName(),
                                p.getSubjects().stream()
                                        .mapToInt(Subject::getScore)
                                        .sum()
                        )
                )
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);

    }

    /**
     * Возвращает предмет с наибольшим баллом для всех студентов.
     * @param stream поток учеников
     * @return лучший предмет или null
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return
                stream.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingInt(Subject::getScore)
                ))
                .entrySet().stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}