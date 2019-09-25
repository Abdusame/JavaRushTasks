package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return Objects.equals(first, solution.first) &&
                Objects.equals(last, solution.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }

    /*public boolean equals(Solution obj) {
        if (obj==null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;
        if (!(obj instanceof Solution)) return false;
        return (obj.first != null && obj.last != null) && obj.first.equals(first) && obj.last.equals(last);
    }

    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }*/

    public static void main(String[] args) {
//        Set<Solution> s = new HashSet<>();
//        s.add(new Solution("Donald", "Duck"));
//        System.out.println(s.contains(new Solution("Donald", "Duck")));
        Solution s1 = new Solution("Donald", "Duck");
        Solution s2 = new Solution("Donald", "Duck");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));
    }
}
