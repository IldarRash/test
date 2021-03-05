package com.company.lesson2;

/*
-- ПРИНЦИП РАБОТЫ --
Калькулятор на основе стэка.  Если это элемент , то мы кладем его на стэк ,
если команда то мы берем два значения из стэка и кладем результат на стэк.
Соотвественно это позволяет коретно работать с обратной польской нотаций

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Так как это польская нотация , то исполнение идет справо налево , а чтение идет слево направо ,
то реализация стэк позволяет последние прочитанные операдны вывести первыми и соотвественно исполнить первыми.
Командой pop, которой мы извлекаем опернды , удаляет их из стэка , соотвественно результат кладется последним
и следующей командой берется результат предыдущей операций и операнд перед ней

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Добавление в стэк стоит 0(1) , удаление стоит O(1).
Операнд только добавляется в стэк , следовательно это операция стоит O(1)
Знак операций делает три действия , берет два последних элемента и добавляет результат
O(1) + O(1) + O(1) = O(1) следовательно знак операций тоже стоит O(1)
Работа всего алгоритма будет стоить длины количество операдов и операций O(k)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Реализация построенна на стэка , следовательно его длина не может превышать
количество операндов , а значит сложность алгоритма будет равно количеству операндов O(n)
*/

// id  успешной посылки 48811568

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
                    stack.push(Math.floorDiv(op2 , op1));
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

