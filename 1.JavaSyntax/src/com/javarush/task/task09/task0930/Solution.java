package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        ArrayList<Integer> listInt = new ArrayList<>();
        ArrayList<String> listStr = new ArrayList<>();
        String tempStr;
        Integer tempInt;
        for (int i = 0; i < array.length; i++) {
            if(isNumber(array[i])){
                listInt.add(Integer.valueOf(array[i]));
            } else {
                listStr.add(array[i]);
            }
        }

        for(int i = listInt.size() - 1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (listInt.get(j) < listInt.get(j + 1)){
                    tempInt = listInt.get(j);
                    listInt.set(j, listInt.get(j + 1));
                    listInt.set(j + 1, tempInt);
                }
            }
        }

        for(int i = listStr.size() - 1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (isGreaterThan(listStr.get(j), listStr.get(j + 1))){
                    tempStr = listStr.get(j);
                    listStr.set(j, listStr.get(j + 1));
                    listStr.set(j + 1, tempStr);
                }
            }
        }

        int j = 0;
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if(isNumber(array[i])){
                array[i] = listInt.get(j).toString();
                j++;
            } else {
                array[i] = listStr.get(k);
                k++;
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
