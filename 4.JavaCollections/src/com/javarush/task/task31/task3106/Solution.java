package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.Arrays;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Arrays.sort(args, 1, args.length);
        Vector<InputStream> streams = new Vector<>();
        for (int i = 1; i < args.length; i++) {
            streams.add(new FileInputStream(args[i]));
        }

        SequenceInputStream sequenceInputStream = new SequenceInputStream(streams.elements());
        ZipInputStream zis = new ZipInputStream(sequenceInputStream);
        ZipEntry zipEntry;
        FileOutputStream resultFile = new FileOutputStream(args[0]);
        zipEntry = zis.getNextEntry();
        byte[] buffer = new byte[1000];
        int c;
        while ((c = zis.read(buffer)) != -1) {
            resultFile.write(buffer, 0, c);
        }
        zis.close();
        resultFile.close();
    }
}
