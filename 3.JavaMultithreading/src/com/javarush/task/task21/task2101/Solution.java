package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] res = new byte[4];
        for (int i = 0; i < res.length; i++) {
            res[i] = (byte) (ip[i] & mask[i]);
        }
        return res;
    }

    public static void print(byte[] bytes) {
        String s1 = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            s1 = String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0');
            sb.append(s1 + " ");
        }
        String result = sb.toString();
        System.out.println(result);
    }
}
