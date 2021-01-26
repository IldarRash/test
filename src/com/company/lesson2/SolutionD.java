package com.company.lesson2;

public class SolutionD {

    public static int solution(Node<String> head, String elem) {
        int i = 0;
        while (head != null) {
            if (head.value.equals(elem)) {
                return i;
            }
            i++;
            head = head.next;
        }

        return -1;
    }
}
