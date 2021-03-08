package com.company.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LikeConfs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = new HashMap<>();
        String[] str = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i ++) {
            Character id = str[i].charAt(0);
            Integer count = map.get(id);
            if (count == null) {
                map.put(id, 1);
            } else {
                map.put(id, count + 1);
            }
        }

        map.entrySet().stream().sorted( new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) return o1.getKey().compareTo(o2.getKey());
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        StringBuilder builder = new StringBuilder();
        for (Character key : map.keySet()) {
            if (k > 0) {
                builder.append(key + " ");
                k--;
            } else {
                break;
            }
        }

        System.out.println(builder.toString().trim());

    }
}
