package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/* 
Задача по алгоритмам
*/

public class Solution {
    static int[] array = new int[30];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        for(int i =0; i<array.length-1;i++) {
            for(int j = i + 1; j<array.length;j++){
                if(array[j]<array[i]){
                    int min=array[j];
                    array[j] = array[i];
                    array[i] = min;
                }
            }
        }
    }
}
