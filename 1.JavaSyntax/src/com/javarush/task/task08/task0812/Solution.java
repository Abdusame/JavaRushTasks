package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        List<Integer> checkList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String str = reader.readLine();
            list.add(Integer.parseInt(str));
        }
        for (int i = 0; i < list.size()-1; i++) {
            int count = 1;
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    count++;
//                    System.out.println(list.toString());
                    j--;
                }
                else break;;
            }
            checkList.add(count);
        }
        Collections.sort(checkList, Collections.reverseOrder());
//        System.out.println(checkList.toString());
        System.out.println(checkList.get(0));
    }
}