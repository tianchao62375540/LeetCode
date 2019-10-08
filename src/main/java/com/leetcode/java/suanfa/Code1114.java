package com.leetcode.java.suanfa;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

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
        //Foo foo = new Foo();
        FooThree foo = new FooThree();
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

/**
 * CountDownLatch 允许一个或者多个线程等待，知道其他线程完成为止
 * 方法一直阻塞，直到由于调用{@link #countDown}方法而导致当前计数达到零为止，
 * 此后*所有等待线程被释放，并且所有后续的* {@link #await调用await}立即返回。
 * 这是一种一次性现象*-无法重置计数。如果您需要一个重置*计数的版本，请考虑使用{@link CyclicBarrier}。
 */
class FooTwo{
    //声明两个 CountDownLatch变量
    private CountDownLatch countDownLatch01;
    private CountDownLatch countDownLatch02;
    public FooTwo() {
        //初始化每个CountDownLatch的值为1，表示有一个线程执行完后，执行等待的线程
        countDownLatch01 = new CountDownLatch(1);
        countDownLatch02 = new CountDownLatch(1);
    }
    public void first(Runnable printFirst) throws InterruptedException {
        //当前只有first线程没有任何的阻碍，其余两个线程都处于等待阶段
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        //直到CountDownLatch01里面计数为0才执行因调用该countDownCatch01.await()而等待的线程
        countDownLatch01.countDown();
    }
    public void second(Runnable printSecond) throws InterruptedException {
        //只有countDownLatch01为0才能通过，否则会一直阻塞
        countDownLatch01.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        //直到CountDownLatch02里面计数为0才执行因调用该countDownCatch02.await()而等待的线程
        countDownLatch02.countDown();
    }
    public void third(Runnable printThird) throws InterruptedException {
        //只有countDownLatch02为0才能通过，否则会一直阻塞
        countDownLatch02.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }


}

class FooThree{
    private Semaphore semaphore01;
    private Semaphore semaphore02;
    public FooThree() {
        semaphore01 = new Semaphore(0);
        semaphore02 = new Semaphore(0);
    }
    public void first(Runnable printFirst) throws InterruptedException {
        //当前只有first线程没有任何的阻碍，其余两个线程都处于等待阶段
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        //直到CountDownLatch01里面计数为0才执行因调用该countDownCatch01.await()而等待的线程
        semaphore01.release();
    }
    public void second(Runnable printSecond) throws InterruptedException {
        //只有countDownLatch01为0才能通过，否则会一直阻塞
        semaphore01.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        //直到CountDownLatch02里面计数为0才执行因调用该countDownCatch02.await()而等待的线程
        semaphore02.release();
    }
    public void third(Runnable printThird) throws InterruptedException {
        semaphore02.acquire();
        printThird.run();
    }


}
