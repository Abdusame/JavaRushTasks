package com.javarush.task.task33.task3312;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
public class Zoo {
    public List<Animal> animals = new ArrayList<>();

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value=Cat.class, name="cat"),
            @JsonSubTypes.Type(value=Dog.class, name="dog")
    })
    public static class Animal {
        public Animal(String name) {
            this.name = name;
        }

        public String name;
    }

    @JsonTypeName(value="dog")
    public static class Dog extends Animal {

        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }

    @JsonTypeName(value="cat")
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        public Cat(String name) {
            super(name);
        }
    }
}