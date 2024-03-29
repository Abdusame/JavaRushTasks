package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:/Users/45Ochil-zodaAZ/Downloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        String fileName = urlString.substring(urlString.lastIndexOf("/"));
        System.out.println(fileName);

        Path tmp = Files.createTempFile("temp-",".tmp");
        Files.copy(inputStream,tmp);

        Path destPath = Paths.get(downloadDirectory.toString() + fileName);
        Files.move(tmp, destPath);

        return destPath;
    }
}
