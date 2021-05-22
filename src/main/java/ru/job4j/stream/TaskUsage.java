package ru.job4j.stream;

import java.util.Date;

public class TaskUsage {

    public static void main(String[] args) {
        Task task = new Task.Builder()
                .buildId(1L)
                .buildTeacherId(1L)
                .buildStudentId(2L)
                .buildDisciplineId(1)
                .buildLessonId(3L)
                .buildClassId(10L)
                .buildWorkTypeId(1)
                .buildWorkNum(1)
                .buildIssued(new Date(System.currentTimeMillis()))
                .buildDeadLine(new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000))
                .buildDescription("Куда-нибудь пойти и что-нибудь найти.")
                .buildStatus(3)
                .buildMark(5D)
                .buildDone(new Date(System.currentTimeMillis() + 3 * 24 * 50 * 60 * 1000))
                .build();
        System.out.println(task);
    }
}
