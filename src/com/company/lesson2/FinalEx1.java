package com.company.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FinalEx1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int size = Integer.parseInt(br.readLine());

        MyDequee dequee = new MyDequee(size);
        for (int i = 0; i < k; i++) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];
            switch (command) {
                case "push_back": {
                    if (dequee.isFull()) {
                        System.out.println("error");
                    } else {
                        dequee.pushBack(Integer.parseInt(commands[1]));
                    }
                    break;
                }

                case "push_front": {
                    if (dequee.isFull()) {
                        System.out.println("error");
                    } else {
                        dequee.pushFront(Integer.parseInt(commands[1]));
                    }
                    break;
                }

                case "pop_back": {
                    if (dequee.isEmpty()) {
                        System.out.println("error");
                    } else {
                        System.out.println(dequee.popBack());
                    }
                    break;
                }

                case "pop_front": {
                    if (dequee.isEmpty()) {
                        System.out.println("error");
                    } else {
                        System.out.println(dequee.popFront());
                    }
                    break;
                }

                default: {
                    break;
                }
            }
        }
    }
}

class MyDequee {

    private int maxSize;
    private ArrayList<Integer> frontElements;
    private ArrayList<Integer> backElements;

    private int frontCount = 0;
    private int backCount = 0;

    MyDequee(int size) {
        maxSize = size;
        frontElements = new ArrayList<>(size/2);
        backElements = new ArrayList<>(size/2);
    }


    public int pushFront(int elem) {
        if (frontElements.size() == maxSize/2) {
            backElements.add(elem);
            backCount++;
        } else {
           frontElements.add(elem);
           frontCount++;
        }
        return elem;
    }

    public int pushBack(int elem) {
        if (backElements.size() == maxSize/2) {
            frontElements.add(elem);
            frontCount++;
        } else {
            backElements.add(elem);
            backCount++;
        }
        return elem;
    }

    public int popFront() {
        int elem = 0;
        if (frontCount == 0) {
            elem = backElements.remove(backCount - 1);
            backCount--;
        } else {
            elem = frontElements.remove(0);
            frontCount--;
        }
        return elem;
    }

    public int popBack() {
        int elem = 0;
        if (backCount == 0) {
            elem = frontElements.remove(frontCount - 1);
            frontCount--;
        } else {
            elem = backElements.remove(0);
            backCount--;
        }
        return elem;
    }

    public boolean isFull() {
        return frontCount + backCount == maxSize;
    }

    public boolean isEmpty() {
        return backElements.isEmpty() && frontElements.isEmpty();
    }

}
