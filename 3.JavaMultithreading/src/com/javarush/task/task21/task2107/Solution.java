package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public User clone() throws CloneNotSupportedException {
            User u = new User(this.age, this.name);
            return u;
        }

        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!(o instanceof User)) return false;
            User us = (User) o;
            return Objects.equals(name, us.name) && age == us.age;
        }

        public int hashCode(){
            return Objects.hash(age, name);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        Solution s = new Solution();
        Map<String, User> userss = new LinkedHashMap();
        userss.putAll(this.users);
        s.users = userss;
        return s;
    }
}
