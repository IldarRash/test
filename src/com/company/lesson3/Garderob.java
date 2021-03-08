package com.company.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Garderob {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int [] grad = new int[m];

        int [] sort = new int[3];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < m; i ++) {
            int elem = Integer.parseInt(str[i]);
            if (elem == 0)
                sort[0] = ++sort[0];
            if (elem == 1)
                sort[1] = ++sort[1];
            if (elem == 2)
                sort[2] = ++sort[2];
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sort[0]; i ++)
            builder.append("0 ");

        for (int i = 0; i < sort[1]; i ++)
            builder.append("1 ");

        for (int i = 0; i < sort[2]; i ++)
            builder.append("2 ");

        System.out.println(builder.toString().trim());
    }
}
