package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        boolean success = hare.tryEat(ball);
        success = wolf.tryEat(ball);
        success = fox.tryEat(ball);
    }
}
