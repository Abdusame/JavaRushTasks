package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        getTokens("level22.lesson13.task01", ".");
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer str = new StringTokenizer(query, delimiter);
        List<String> list = new ArrayList<>();

        while (str.hasMoreTokens()){
            list.add(str.nextToken());
        }

        System.out.println(list);

        return list.toArray(new String[list.size()]);
    }
}
