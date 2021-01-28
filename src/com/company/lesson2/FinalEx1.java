package com.company.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FinalEx1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int size = Integer.parseInt(br.readLine());

        FixQueue queue = new FixQueue();
        for (int i = 0; i < k; i++) {
            String command = br.readLine();
            switch (command) {
                case "peek": {
                    if (queue.size() == 0) {
                        System.out.println("None");
                    } else {
                        System.out.println(queue.peek());
                    }
                    break;
                }

                case "pop": {
                    if (queue.size() == 0) {
                        System.out.println("None");
                    } else {
                        System.out.println(queue.pollFirst());
                    }
                    break;
                }

                case "size": {
                    System.out.println(queue.size());
                    break;
                }

                default: {
                    String[] strings = command.split(" ");
                    if (size == queue.size()) {
                        System.out.println("error");
                    } else {
                        queue.offerLast(Integer.parseInt(strings[1]));
                    }
                    break;
                }
            }
        }
    }
}

class MyDequee {

    private int maxSize;
    private Integer[] frontElements;
    private Integer[] backElements;

    MyDequee(int size) {
        maxSize = size;
        frontElements = new Integer[size/2];
        backElements = new Integer[size/2];
    }


}
