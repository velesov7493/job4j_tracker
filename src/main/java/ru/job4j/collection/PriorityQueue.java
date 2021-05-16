package ru.job4j.collection;

import java.util.LinkedList;

/**
 * Класс описывает простейшую очередь по приоритету,
 * которая работает по принципу FIFO (first in - first out)
 * @version 1.0
 */
public class PriorityQueue {

    /**
     * Задачи хранятся в коллекции LinkedList
     */
    private LinkedList<Task> tasks;

    public PriorityQueue() {
        tasks = new LinkedList<>();
    }

    /**
     * Метод принимает на вход задачу и добавляет ее в очередь.
     * Если встречаются 2 задачи с одинаковым приоритетом,
     * то в очереди они распределяются по принципу FIFO
     * @param task задача, которая добавляется в очередь.
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (element.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * Метод позволяет получить первую задачу в очереди.
     * @return возвращает задачу из головы очереди или null, если очередь пуста.
     */
    public Task take() {
        return tasks.poll();
    }
}
