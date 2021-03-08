package com.company.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pattern {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pattern = br.readLine();
        String str = br.readLine();

        find(pattern, str, 0, 0, false);
    }

    private static void find(String patt, String str, int len, int indexPat, boolean flag) {

        if (patt.length() == 0 || str.length() == 0) {
            System.out.println("True");
            return;
        }
        if (str.length() == len || flag) {
            System.out.println(flag ? "True" : "False");
            return;
        }

        Character one = patt.charAt(indexPat);
        Character two = str.charAt(len);

        if (one.equals(two)) {
            find(patt, str, len + 1, indexPat + 1, indexPat == patt
            .length() - 1);
        } else {
            find(patt, str, len + 1, indexPat, flag);
        }
    }


}
