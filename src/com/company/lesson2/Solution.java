package com.company.lesson2;

public class Solution {

    public static Node<String> solution(Node<String> head) {
        Node<String> curr = head;
        Node<String> prev = null;
        Node<String> temp;

        while (curr != null ) {
            temp = curr.next;
            curr.next = prev;
            curr.prev = temp;
            curr = temp;
            if (curr != null) {
                prev = curr.prev;
            }

        }

        return prev.prev;
    }

    public static void main(String[] args) {
        Node<String> zero = new Node<>("0", null, null);
        Node<String> first = new Node<>("1", null, null);
        Node<String> second = new Node<>("2", null, null);
        Node<String> thrid = new Node<>("3", null, null);
        Node<String> four = new Node<>("4", null, null);

        zero.next = first;
        first.prev= zero;
        first.next = second;

        second.next = thrid;
        second.prev = first;

        thrid.next = four;
        thrid.prev = second;

        four.prev=thrid;


        solution(zero);
    }
}


class Node<V> {
    public V value;
    public Node<V> next;
    public Node<V> prev;

    public Node(V value, Node<V> next, Node<V> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
