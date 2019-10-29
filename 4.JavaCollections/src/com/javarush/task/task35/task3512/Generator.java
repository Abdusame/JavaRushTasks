package com.javarush.task.task35.task3512;

public class Generator<T> {
    private Class<T> instance;

    public Generator(Class<T> clazz) {
        this.instance = clazz;
    }

    public T newInstance() throws IllegalAccessException, InstantiationException {
        return instance.newInstance();
    }
}
