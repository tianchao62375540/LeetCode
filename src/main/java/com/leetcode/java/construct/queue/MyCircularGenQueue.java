package com.leetcode.java.construct.queue;
/**
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 *
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 *
 * 你的实现应该支持如下操作：
 *
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 */

import java.util.ArrayList;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/11 10:50
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class MyCircularGenQueue<T> {
    private T[] data;
    private int head;
    private int tail;
    private int size;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    //构造器，设置队列长度为 k 。
    public MyCircularGenQueue(int k) {
        data = (T[])new Object[k];
        head = -1;
        tail = -1;
        size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(T value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            head = 0;
        }
        tail = (tail + 1)%size;
        data[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(head == tail){
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1)%size;
        return true;
    }
    public T deQueueGet(){
        int head_temp = head;
        return deQueue()?data[head_temp]:null;
    }

    /** Get the front item from the queue. */
    //从队首获取元素。如果队列为空，返回 -1
    public T Front() {
        if(isEmpty()){
            return null;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    //获取队尾元素。如果队列为空，返回 -1 。
    public T Rear() {
        if (isEmpty()) {
            return null;
        }
        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    //检查循环队列是否已满。
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }

    public int size(){
        if (isEmpty()){
            return 0;
        }
        return head<=tail?tail-head+1:size-head+tail+1;
    }

    public static void main(String[] args) {
        MyCircularGenQueue<String> queue = new MyCircularGenQueue<String>(5);
        queue.enQueue("a");
        queue.enQueue("b");
        System.out.println(queue.size());
        queue.enQueue("c");
        queue.enQueue("d");
        queue.enQueue("e");
        boolean f = queue.enQueue("f");
        System.out.println("添加f成功了吗"+f);
        System.out.println(queue.size());
        String s = queue.deQueueGet();
        System.out.println("拿出一个"+s+"长度变成了"+queue.size());
        boolean f1 = queue.enQueue("F");
        System.out.println("加入一个F-"+f1+"长度变成了"+queue.size());
        System.out.println(queue.enQueue("xx'"));
        System.out.println(queue.deQueueGet());
        System.out.println(queue.deQueueGet());
        System.out.println(queue.deQueueGet());
        System.out.println(queue.deQueueGet());
        System.out.println(queue.deQueueGet());
        System.out.println(queue.deQueueGet());
        System.out.println(queue.deQueueGet());
        System.out.println(queue.deQueueGet());
        System.out.println(queue.head+"    "+queue.tail+"      "+queue.size+"      "+queue.size());


    }
}
