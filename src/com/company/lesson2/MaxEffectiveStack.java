package com.company.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaxEffectiveStack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        MaxStack stack = new MaxStack();
        for (int i = 0; i< k; i++) {
            String command = br.readLine();
            switch (command) {
                case "get_max" : {
                    if (stack.isEmpty()) {
                        System.out.println("None");
                    } else {
                        System.out.println(stack.getMax());
                    }
                    break;
                }

                case "pop" : {
                    if (stack.isEmpty()) {
                        System.out.println("error");
                    } else {
                        stack.pop();
                    }
                    break;
                }

                default: {
                    String[] strings = command.split(" ");
                    stack.push(Integer.parseInt(strings[1]));
                    break;
                }
            }
        }
    }


}


class MaxStack extends Stack<Integer> {
    private Stack<Integer> maxElements = new Stack<>();

    public Integer getMax() {
        return maxElements.peek();
    }

    @Override
    public Integer push(Integer item) {
        if (maxElements.isEmpty()) {
            maxElements.push(item);
        } else {
            Integer maxElem = maxElements.peek();
            if (maxElem <= item) {
                maxElements.push(item);
            }
        }
        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {
        Integer max = maxElements.peek();
        Integer popItem = super.pop();
        if (max.equals(popItem)) {
            maxElements.pop();
        }
        return popItem;
    }

    @Override
    public synchronized Integer peek() {
        return super.peek();
    }
}