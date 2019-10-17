package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> h = new ArrayList<>();
        h.add(new Horse("Mustang", 3, 0));
        h.add(new Horse("Marusya", 3, 0));
        h.add(new Horse("Eleonora", 3, 0));

        game = new Hippodrome(h);
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (int i = 0; i < getHorses().size(); i++) {
            getHorses().get(i).move();
        }
    }

    public void print(){
        for (int i = 0; i < getHorses().size(); i++) {
            getHorses().get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        double distMax = 0;
        Horse winner = null;
        for (int i = 0; i < horses.size(); i++) {
            double dist = horses.get(i).getDistance();
            if (dist > distMax){
                distMax = dist;
                winner = horses.get(i);
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
