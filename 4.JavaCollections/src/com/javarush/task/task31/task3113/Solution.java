package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Что внутри папки?
*/
public class Solution {
    private static List<Path> listOfDirs = new ArrayList<>();
    private static List<Path> listOfFiles = new ArrayList<>();
    private static long size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());
        if (!Files.isDirectory(path)){
            System.out.println(path + " - не папка");
        } else {
            Files.walkFileTree(path, new MyFileVisitor());
            System.out.println("Всего папок - " + (listOfDirs.size() - 1));
            System.out.println("Всего файлов - " + listOfFiles.size());
            System.out.println("Общий размер - " + size);
        }
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            listOfDirs.add(dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            listOfFiles.add(file);
            size += Files.size(file);
            return FileVisitResult.CONTINUE;
        }
    }
}
