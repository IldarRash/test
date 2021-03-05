package com.company.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenScobki {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        gen(new Character[n * 2], 0, 0 , n * 2);

    }



    private static void gen(Character[] str, int index, int cnt, int n) {

        if (cnt <= n - index - 2) {
            str[index] = '(';
            gen(str, index + 1, cnt + 1, n);
        }

        if (cnt > 0) {
            str[index] = ')';
            gen(str, index + 1, cnt - 1, n);
        }

        if (index == n) {
            if (cnt == 0) {
                formatStr(str);
            }
        }

    }

    private static void formatStr(Character[] arr) {
        StringBuilder builder = new StringBuilder();
        for(Character character : arr) {
            builder.append(character);
        }
        System.out.println(builder.toString());
    }
}
