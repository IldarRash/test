package com.company.lesson1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sosedi {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] arrs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(arrs[j]);
            }
        }

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        List<Integer> sosedi = new ArrayList();

        add(a, x, y, sosedi);
        sosedi.sort(Integer::compareTo);

        for (Integer s : sosedi) {
            System.out.print(s + " ");
        }
    }


    public static void add(int[][] matrix , int x, int y, List<Integer> sosedi) {
        int lenStr = matrix.length;
        int lenStolb = matrix[0].length;

        if (x < lenStr - 1) {
            sosedi.add(matrix[x + 1][y]);
        }

        if (x > 0) {
            sosedi.add(matrix[x - 1][y]);
        }


        if (y < lenStolb - 1) {
            sosedi.add(matrix[x][y + 1]);
        }

        if (y > 0) {
            sosedi.add(matrix[x][y - 1]);
        }
    }
}