package com.company.lesson2;

/*
-- ПРИНЦИП РАБОТЫ --
Я реализовал дэк на массиве.
Так как конечная длинна известна , то добавления в конце массива и в начало будет за константное время
Мы запоминаем индекс последнего довлаенного элемента в начало и в конец
И при добавление или при удаления с конца или начала переставляем индексы начала или конца


-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Так как нам нужен дэк , то главные условия реализаций это доавление в начало и в конец за O(1)
и удаление в начало и в конец за O(1). Соотвественно так как наша реализация сделана на массиве , то
добавление и удаленние по индексу будет стоить O(1), а индексы начала и конца всегда есть ,
 следовательно и операций добавление в начало и в конец будут стоить O(1),
  так же и для удаления

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Про временную сложность описывал выше


-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Дэк сделан на массиве следовательно у него может быть не было O(n) элементов
*/

// id  успешной посылки 49161734


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FinalEx1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int size = Integer.parseInt(br.readLine());

        MyDeque dequee = new MyDeque(size);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];
            switch (command) {
                case "push_back": {
                    if (dequee.size() == size) {
                       builder.append("error\n");
                    } else {
                        dequee.pushBack(Integer.parseInt(commands[1]));
                    }
                    break;
                }

                case "push_front": {
                    if (dequee.size() == size) {
                        builder.append("error\n");
                    } else {
                        dequee.pushFront(Integer.parseInt(commands[1]));
                    }
                    break;
                }

                case "pop_back": {
                    if (dequee.size() == 0) {
                        builder.append("error\n");
                    } else {
                       builder.append(dequee.popBack() + "\n");
                    }
                    break;
                }

                case "pop_front": {
                    if (dequee.size() == 0) {
                        builder.append("error\n");
                    } else {
                        builder.append(dequee.popFront() + "\n");
                    }
                    break;
                }

                default: {
                    break;
                }
            }
        }

        System.out.println(builder.toString().trim());
    }
}

class MyDeque {
    private int size;
    private int head, end;
    private int[] data;
    private int maxSize;

    public MyDeque(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
        head = 0;
        end = 0;
        size = 0;
    }

    public void pushFront(int e) {
       if (size==0) {
            end = head;
            data[head] = e;
            size++;
        }
        else {
            head++;
            if (head>=maxSize)
                head = 0;
            data[head] = e;
            size++;
        }
    }

    public void pushBack(int e) {
        if (size==0) {
            head = end;
            data[end] = e;
            size++;
        }
        else {
            end--;
            if (end<0)
                end = maxSize-1;
            data[end] = e;
            size++;
        }
    }

    public int popBack() {
        int tmp = data[end];
        end++;
        if (end>=maxSize)
            end = 0;
        size --;
        return tmp;
    }

    public int popFront() {
        int tmp = data[head];
        head--;
        if (head<0)
            head = maxSize - 1;
        size --;
        return tmp;
    }

    public int size() {
        return size;
    }
}