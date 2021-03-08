package com.company.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Houses {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int max = Integer.parseInt(str[1]);
        int [] houses = new int[m];
        String[] str2 = br.readLine().split(" ");
        for (int i = 0; i < m; i ++) {
            houses[i] = Integer.parseInt(str2[i]);
        }
        int count = 0;
        int agg = 0;
        Arrays.sort(houses);
        for (Integer house : houses) {
            if (house + agg <= max) {
                count++;
                agg += house;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}
