package ru.job4j.pojo;

public class Library {

    public static void exchange(Book[] data, int source, int dest) {
        Book tmp = data[source];
        data[source] = data[dest];
        data[dest] = tmp;
    }

    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Clean code", 464);
        books[1] = new Book("Java Полное руководство 10 издание", 1488);
        books[2] = new Book("Философия Java 4 издание", 631);
        books[3] = new Book("Разработка web-служб средствами Java", 384);
        for (Book item : books) {
            System.out.println(item.getName() + " : " + item.getPagesCount());
        }
        exchange(books, 0, 3);
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " : " + books[i].getPagesCount());
        }
        for (Book item : books) {
            if ("Clean code".equals(item.getName())) {
                System.out.println(item.getName() + " : " + item.getPagesCount());
            }
        }
    }
}
