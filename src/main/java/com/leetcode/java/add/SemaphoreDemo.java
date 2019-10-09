package com.leetcode.java.add;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/8 16:30
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class SemaphoreDemo {
    private Semaphore smp = new Semaphore(2);
    private String outer = "outer";
    private Random rnd = new Random();
    class TaskDemo implements Runnable {

        private String outer = "inner";
        private String id;

        public TaskDemo(String id) {
            //System.out.println("===init:"+SemaphoreDemo.this);
            this.id = id;
        }

        @Override
        public void run() {
            try {
                //System.out.println(SemaphoreDemo.this.outer);
                smp.acquire();
                System.out.println("Thread " + id + " is working");
                Thread.sleep(rnd.nextInt(1000));
                smp.release();
                System.out.println("Thread " + id + " is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        SemaphoreDemo demo = new SemaphoreDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable ra = demo.new TaskDemo("a");
        Runnable rb = demo.new TaskDemo("b");
        Runnable rc = demo.new TaskDemo("c");
        Runnable rd = demo.new TaskDemo("d");
        Runnable re = demo.new TaskDemo("e");
        Runnable rf = demo.new TaskDemo("f");
        Runnable rg = demo.new TaskDemo("g");
        Runnable rh = demo.new TaskDemo("h");

        executorService.execute(ra);
        executorService.execute(rb);
        executorService.execute(rc);
        executorService.execute(rd);
        executorService.execute(re);
        executorService.execute(rf);
        executorService.execute(rg);
        executorService.execute(rh);
    }
}
