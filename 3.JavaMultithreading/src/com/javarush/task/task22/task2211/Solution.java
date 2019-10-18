package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[0]);
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        String content = new String(bytes, "Windows-1251");
        byte[] bytes1 = content.getBytes("UTF-8");
        FileOutputStream out = new FileOutputStream(args[1]);
        out.write(bytes1);
        out.close();
        in.close();
    }
}
