package com.javarush.task.task09.task0906;

/* 
Логирование стек-трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        try {
            throw new Exception("Who called me?");
        } catch( Exception e ) {
            System.out.println(e.getStackTrace()[1].getClassName() + ": " + e.getStackTrace()[1].getMethodName() + ": " + s);
        }
    }
}
