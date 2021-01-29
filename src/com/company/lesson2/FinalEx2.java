package com.company.lesson2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class FinalEx2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");

        Stack<Integer> stack = new Stack<>();
        for (String command : lines) {
            switch (command) {
                case "+": {
                    Integer result = stack.pop() + stack.pop();
                    stack.push(result);
                    break;
                }

                case "-": {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op2 - op1);
                    break;
                }

                case "*": {
                    Integer result = stack.pop() * stack.pop();
                    stack.push(result);
                    break;
                }

                case "/": {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op2 / op1);
                    break;
                }

                default: {
                    stack.push(Integer.parseInt(command));
                    break;
                }
            }
        }

        System.out.println(stack.peek());
    }
}

