package com.company.lesson2;

public class SolutionC {

    public static Node<String> solution(Node<String> head, int idx) {
        if (idx == 0) {
            return head.next;
        } else {
            int i = 1;
            Node<String> prev = head;
            Node<String> curr = head.next;
            while (curr != null) {
                if (i == idx) {
                    prev.next = curr.next;
                    return head;
                } else {
                    i++;
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return head;
    }
}
