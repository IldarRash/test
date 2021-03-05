package com.company.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private static List<Character> two = List.of('a', 'b', 'c');
    private static List<Character> three = List.of('d', 'e', 'f');
    private static List<Character> four = List.of('g', 'h', 'i');
    private static List<Character> five = List.of('j', 'k', 'l');
    private static List<Character> six = List.of('m', 'n', 'o');
    private static List<Character> seven = List.of('p', 'q', 'r', 's');
    private static List<Character> eight = List.of('t', 'u', 'v');
    private static List<Character> nine = List.of('w', 'x', 'y', 'z');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<List<Character>> combines = new ArrayList<>();
        for(Character ch : str.toCharArray()) {
            switch (ch) {
                case '2' -> combines.add(two);
                case '3' -> combines.add(three);
                case '4' -> combines.add(four);
                case '5' -> combines.add(five);
                case '6' -> combines.add(six);
                case '7' -> combines.add(seven);
                case '8' -> combines.add(eight);
                case '9' -> combines.add(nine);
            }
        }
        //gen(combines, str.length(), 0, new Character[4], combines.get(0));
    }

    private static void gen(List<List<Character>> combines, int len, int index, List<Character> curr) {
        if (index == curr.size() - 1){

           // gen();
        }

        if (len == combines.size() - 1) {
            if (index == curr.size() - 1) {
               // formatStr(str);
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
