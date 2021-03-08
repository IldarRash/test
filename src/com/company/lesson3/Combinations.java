package com.company.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    private static List<Character> two = Arrays.asList('a', 'b', 'c');
    private static List<Character> three = Arrays.asList('d', 'e', 'f');
    private static List<Character> four = Arrays.asList('g', 'h', 'i');
    private static List<Character> five = Arrays.asList('j', 'k', 'l');
    private static List<Character> six = Arrays.asList('m', 'n', 'o');
    private static List<Character> seven = Arrays.asList('p', 'q', 'r', 's');
    private static List<Character> eight = Arrays.asList('t', 'u', 'v');
    private static List<Character> nine = Arrays.asList('w', 'x', 'y', 'z');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Character> combines = new ArrayList<>();
        for (int i = 0; i < str.length(); i ++) {
            combines.add(str.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        gen(combines, builder, 0,"");

        System.out.println(builder.toString().trim());
    }

    private static void gen(List<Character> combines, StringBuilder curr, int index, String str) {
        if (combines.size() == index) {
            curr.append(str + " ");
            return;
        }
        Character ch = combines.get(index);
        switch (ch) {
            case '2' : {
                for (Character character : two) {
                    gen(combines, curr, index + 1, str + character);
                }
                break;
            }
            case '3' : {
                for (Character character : three) {
                    gen(combines, curr,index + 1, str + character);
                }
                break;
            }
            case '4' : {
                for (Character character : four) {
                    gen(combines, curr,index + 1, str + character);
                }
                break;
            }
            case '5' : {
                for (Character character : five) {
                    gen(combines, curr, index + 1,str + character);
                }
                break;
            }
            case '6' : {
                for (Character character : six) {
                    gen(combines, curr, index + 1,str + character);
                }
                break;
            }
            case '7' : {
                for (Character character : seven) {
                    gen(combines, curr,index + 1, str + character);
                }
                break;
            }
            case '8': {
                for (Character character : eight) {
                    gen(combines, curr,index + 1, str + character);
                }
                break;
            }
            case '9' : {
                for (Character character : nine) {
                    gen(combines, curr,index + 1, str + character);
                }
                break;
            }
        }
    }
}
