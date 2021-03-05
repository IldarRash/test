package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer i = 127;
        i = Inc(i);

        class A { }

        Set<A> set = new HashSet<>();
        set.add(new A());
        set.add(new A());
        System.out.println(set.size());
        System.out.println(i);

        class Test {
            private int a, b;
            private volatile int x, y;

            public void setA() {
                a = 1;
                x = b;
                System.out.println("x = " + x);
            }

            public void setB() {
                b = 1;
                y = a;
                System.out.println("y = " + y);
            }
        }

        ExecutorService service = Executors.newFixedThreadPool(2);
        Test test = new Test();

        service.submit(test::setA);
        service.submit(test::setB);
        service.shutdown();
    }

    static Integer Inc(Integer y) {
        y = 5;
        return y;
    }
}
