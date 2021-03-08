package com.company.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PacnCackecs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        List<Integer> childs = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        Integer m = Integer.valueOf(br.readLine());
        List<Integer> pancks = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());


        int count = 0;
        for (Integer child : childs) {
            if (find(child, pancks) != -1) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static int find (int child, List<Integer> pancks) {
        int index = -1;
        for (int i =0; i< pancks.size(); i++) {
            if (pancks.get(i) >= child) {
                index = i;
                break;
            }
        }
        return index == -1 ? -1 : pancks.remove(index);

    }
}
