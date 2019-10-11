package com.leetcode.java.construct.queue;


import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/11 10:15
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class MyQueue<T> {
    private List<T> data;
    private int p_start;
    public MyQueue(){
        data = new ArrayList<>();
        p_start = 0;
    }
    public MyQueue<T> enQueue(T obj){
        data.add(obj);
        return this;
    }
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        p_start++;
        return true;
    }
    public T deQueueGet(){
        if(isEmpty()){
            return null;
        }
        return data.get(p_start++);
    }
    public int size(){
        return data.size() - p_start;
    }

    private boolean isEmpty() {
        return p_start >= data.size();
    }

    public static void main(String[] args) {
        MyQueue<String> queue= new MyQueue<>();
        System.out.println("新建队列长度:"+queue.size());
        System.out.println("插入abcd");
        queue.enQueue("a").enQueue("b").enQueue("c").enQueue("d");
        System.out.println("插入abcd后长度:"+queue.size());
        boolean b = queue.deQueue();
        System.out.println("删除成功了吗:"+b);
        String s = queue.deQueueGet();
        System.out.println("删除成功并返回:"+s);
        System.out.println("删除两次后长度："+queue.size());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
