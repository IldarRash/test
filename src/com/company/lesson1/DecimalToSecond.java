package com.company.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecimalToSecond {

    public static void main(String[] args)throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());


        System.out.println(binar(k) ? "True" : "False");
    }

    private static boolean binar(int a){
        int b;
        boolean flag = true;
        while(a > 4){
            b = a%4;

            if (b != 0) {
                flag = false;
            }
            a = a/4;
        }

        return flag;
    }
}