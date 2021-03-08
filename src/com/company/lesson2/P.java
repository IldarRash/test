package com.company.lesson2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FooBar {
    private int n;
    private volatile boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (flag) {
                printFoo.run();
                flag = false;
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (!flag) {
                printBar.run();
                flag = true;
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.print("foo");
        });

        Thread thread2 = new Thread(() -> {
            System.out.print("bar");
        });

        FooBar fooBar = new FooBar(3);
        fooBar.foo(thread1);
        fooBar.bar(thread2);
    }
}

