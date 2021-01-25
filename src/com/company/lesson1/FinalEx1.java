package com.company.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalEx1 {
    // успешная попытка 47190518
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        Integer[] array = Arrays.stream(strings).map(Integer::parseInt).toArray(Integer[]::new);

        int l = -1;
        int r = 0;
        boolean needrefact = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (i == 0) {
                    l = 0;
                }
                if (i != 0) {
                    r = i;
                    needrefact = true;
                }
            }

            if (needrefact || i == array.length - 1) {
                refactorArray(l, r, array);
                needrefact = false;
                l = r;
                r = 0;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            builder.append(" ");
        }

        System.out.println(builder.toString().trim());
    }

    private static void refactorArray(int left, int rigth, Integer[] oldArray) {
        if (left == -1) {
            for (int i = 0; i < rigth; i ++) {
                oldArray[i] = rigth - i;
            }
            return;
         }

        if (rigth == 0) {
            for (int i = left; i < oldArray.length; i ++) {
                oldArray[i] = i - left;
            }
            return;
        }

        int i = left;
        while (i != rigth) {
            int relem = rigth - i;
            int lelem = i - left;
            if (relem < lelem) {
                oldArray[i] = relem;
            } else {
                oldArray[i] = lelem;
            }
            i++;
        }

    }
}
