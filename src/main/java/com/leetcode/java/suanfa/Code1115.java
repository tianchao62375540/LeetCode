package com.leetcode.java.suanfa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/9 09:03
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class Code1115 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable fooObj = () -> {
            System.out.print("foo");
        };
        Runnable barObj = () -> {
            System.out.print("bar");
        };
        FooBar fooBar = new FooBar(5);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(fooObj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(barObj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}

class FooBar {
    private int n;
    //true foo执行  false bar执行
    private boolean flag = true;
    private Object obj = new Object();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (obj) {
            for (int i = 0; i < n; i++) {
                while (!flag) {
                    obj.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = false;
                obj.notifyAll();
            }
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (obj) {
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                while (flag) {
                    obj.wait();
                }
                printBar.run();
                flag =true;
                obj.notifyAll();
            }
        }
    }
}

