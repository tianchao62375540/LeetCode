package com.leetcode.java.suanfa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/8 08:26
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class Code1114 {
    public static void main(String[] args) {
        Foo foo = new Foo();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable aR = () -> {
            System.out.println("one");
        };
        Runnable bR = () -> {
            System.out.println("two");
        };
        Runnable cR = ()-> {
                System.out.println("three");
        };
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(cR);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(bR);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(aR);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("end=====");
    }
}

class Foo {

    int flag = 0;

    Object obj = new Object();

    public Foo() {

    }

    public void one() {
        System.out.println("first");
    }

    public void two() {
        System.out.println("second");
    }

    public void three() {
        System.out.println("third");
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (obj){
            while (flag!=0){
                obj.wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 1;
            obj.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (obj){
            while (flag!=1){
                obj.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 2;
            obj.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (obj){
            while (flag!=2){
                obj.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag = 0;
            obj.notifyAll();
        }

    }
}
