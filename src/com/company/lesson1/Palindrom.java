package com.company.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word = delNoDigOrLet(br.readLine().toLowerCase()).toCharArray();

        boolean palin = palindrom(word);

        System.out.println(palin ? "True" : "False");
    }

    static boolean palindrom(char [] word) {
        boolean flag = dividesByTwo(word.length);

        if (word.length <= 0) {
            return false;
        }

        if (word.length == 1) {
            return true;
        }

        int i = 0;
        int j = word.length - 1;
        if (flag) {
            do {
                if (word[i] != word[j]) {
                    return false;
                }
                i++;
                j--;
            } while ( j - i > 0);
        } else {
            do {
                if (word[i] != word[j]) {
                    return false;
                }
                i++;
                j--;
            } while ( j - i != 0);
        }

        return true;
    }

    static boolean dividesByTwo(int a){
        return (a%2==0);
    }


    private static String delNoDigOrLet (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character .isLetterOrDigit(s.charAt(i)))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
