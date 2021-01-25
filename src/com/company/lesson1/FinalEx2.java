package com.company.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FinalEx2 {
    //успешная попытка 47194731
    private static final Character pp = '.';

    private static final Character[] rounds = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String firstLine = br.readLine();
        String secondLine = br.readLine();
        String thirdLine = br.readLine();
        String fourLine = br.readLine();

        Map<Character, Integer> pointMap = new HashMap<>();
        uploadMap(firstLine, pointMap);
        uploadMap(secondLine, pointMap);
        uploadMap(thirdLine, pointMap);
        uploadMap(fourLine, pointMap);

        int result = 0;
        for (Character round : rounds) {
            Integer count = pointMap.get(round);
            if (count != null && count <= k * 2) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void uploadMap(String line, Map<Character, Integer> pointMap) {
        for (Character ch : line.toCharArray()) {
            if (ch.equals(pp)) continue;
            else {
               Integer count = pointMap.get(ch);
               if (count == null) pointMap.put(ch, 1);
               else pointMap.put(ch, ++count);
            }
        }
    }
}
