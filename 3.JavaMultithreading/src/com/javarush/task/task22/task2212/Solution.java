package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null || telNumber.isEmpty()){
            return false;
        }
        int length = telNumber.replaceAll("\\D", "").length();
        /*if (telNumber.matches("\\d*[^\\d,\\^+,\\-,\\(,\\)]\\d*")) return false;
        if (telNumber.matches("^\\+\\d{12}") && length == 12) return true;
        if (telNumber.matches("\\d{10}") && length == 10) return true;
        if (telNumber.matches("^\\+\\d*-?\\d*-?\\d*" ) && length == 12) return true;
        if (telNumber.matches("^\\d*-?\\d*-?\\d*" ) && length == 10) return true;*/
        if (telNumber.contains("[a-aA-Z]")) {return false;}
        if (length==12) {
            return telNumber.matches("(^\\+{1})\\d*(\\(\\d{3}\\))?\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        }
        else if (length==10) {
            return telNumber.matches("^(\\d|\\(\\d{3}\\))\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        }

        return false;
    }

    public static void main(String[] args) {
        /*System.out.println(checkTelNumber("0501234567"));
        System.out.println(checkTelNumber("050ччx4567"));
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38050123456700"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("+3805-0123-45-67"));
        System.out.println(checkTelNumber("0500204567"));
        System.out.println(checkTelNumber("0500204567000"));
        System.out.println(checkTelNumber("05002-04567"));
        System.out.println(checkTelNumber("+05002-04567"));*/

        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));

    }
}
