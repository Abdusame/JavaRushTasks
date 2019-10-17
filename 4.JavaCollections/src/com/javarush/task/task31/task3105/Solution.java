package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[2];
        //args[0] = "C:\\Users\\45Ochil-zodaAZ\\Desktop\\test.txt";
        //args[1] = "C:\\Users\\45Ochil-zodaAZ\\IdeaProjects\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3105\\pack.zip";

        ZipInputStream zis = new ZipInputStream(new FileInputStream(args[1]));
        ByteArrayOutputStream byteOut;

        Map<String, byte[]> savedData = new HashMap<>();
        byte[] readedBytes;
        int readedCount;

        ZipEntry ze;

        while ((ze = zis.getNextEntry()) != null) {
            if (ze.getName().equals("new/" + Paths.get(args[0]).getFileName())){
                continue;
            }
            byteOut = new ByteArrayOutputStream();
            readedBytes = new byte[1000];
            while ((readedCount = zis.read(readedBytes)) != -1) {
                byteOut.write(readedBytes, 0, readedCount);
            }
            savedData.put(ze.toString(), byteOut.toByteArray());
        }
        zis.close();

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(args[1]));
        zos.putNextEntry(new ZipEntry("new/" + Paths.get(args[0]).getFileName()));

        Files.copy(Paths.get(args[0]), zos);

        for (Map.Entry<String, byte[]> entry: savedData.entrySet()) {
            zos.putNextEntry(new ZipEntry(entry.getKey()));
            zos.write(entry.getValue());
        }
        zos.close();

    }
}
