package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.recurse(102);
    }

    public void recurse(int n) {
        int m = 2;
        if (n <= 1){
            return;
        }
        while (m <= n) {
            if (n % m == 0) {
                System.out.print(m + " ");
                if (m == n)
                   return;
                break;
            }
            m++;
        }
        recurse(n/m);
    }
}
