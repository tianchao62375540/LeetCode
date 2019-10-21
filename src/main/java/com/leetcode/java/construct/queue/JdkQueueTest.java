package com.leetcode.java.construct.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/21 10:49
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 * poll
 * peek
 */
public class JdkQueueTest {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        System.out.println("The first element is: " + q.peek());//The first element is: null
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        Integer poll = q.poll();
        System.out.println("拿出"+poll);//拿出1
        System.out.println("剩下的队首"+q.peek());//剩下的队首2
        System.out.println(q.size());//4
    }
}
