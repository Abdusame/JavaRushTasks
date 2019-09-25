package com.javarush.task.task31.task3109;

import java.io.*;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
//        File.separator
        Properties pr = new Properties();
        String str = fileName.substring(fileName.lastIndexOf(".") + 1);
        File file = new File(fileName);
        try {
            if (file.exists()) {
                if (str.equals("xml")) {
                    pr.loadFromXML(new FileInputStream(fileName));
                } else {
                    pr.load(new BufferedReader(new FileReader(fileName)));
                }
            }
        } catch (Exception e){
            return pr;
        }
        return pr;
    }
}
