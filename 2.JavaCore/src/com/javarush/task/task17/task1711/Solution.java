package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.javarush.task.task17.task1711.Sex.MALE;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String... args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat sdfOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int lastIndex = allPeople.size() - 1;
        if (args[0].equals("-c")){
            createMan(args, sdfInput);
            printMan(lastIndex, sdfOutput);
        } else if (args[0].equals("-u")){

        } else if (args[0].equals("-d")){

        } else if (args[0].equals("-i")){

        }
    }

    public static void createMan(String[] args, SimpleDateFormat sdf) throws ParseException {
        if (args.length >=4 && args.length % 3 == 1) {
            for (int i = 1; i < args.length; i += 4) {
                if (args[i + 1].equals("м")) {
                    allPeople.add(Person.createMale(args[i], sdf.parse(args[i + 2])));
                } else if (args[i + 1].equals("ж")) {
                    allPeople.add(Person.createFemale(args[i], sdf.parse(args[i + 2])));
                }
            }
        }
    }

    public static void updateMan(String[] args, SimpleDateFormat sdf){
        if (args.length >= 5 && args.length % 4 == 1) {
            for (int i = 1; i < args.length; i += 5) {
                Person p = allPeople.get(Integer.valueOf(args[i]));
            }
        }
    }

    public static void printMan(int lastIndex, SimpleDateFormat sdfOutput){
        for (int i = lastIndex + 1; i < allPeople.size(); i++) {
            Person p = allPeople.get(i);
            String s = ((p.getSex() == MALE) ? "м" : "ж");
            String bd = sdfOutput.format(p.getBirthDate());
            System.out.println(p.getName() + " " + s +  " " + bd);
        }
    }
}
