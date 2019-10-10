package com.leetcode.java.sf.jichu.z111;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.*;
import java.util.Arrays;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/9 20:10
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class BinarySearch {
    public static int rank(int key,int[] a){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(key <a[mid]){
                hi = mid - 1;
            }else if(key > a[mid]){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        File file  = new File(args[0]);
        System.out.println(file.getAbsolutePath());
        FileInputStream fis = null;
        FileOutputStream fos = null;
        System.out.println(file.exists());
        if(file.exists()){
            fis = new FileInputStream(file);
            byte[] buf = new byte[8 * 1024];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                System.out.println(new String(buf));
            }

        }
       /* int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(rank(key,whitelist) == -1){
                StdOut.println(key);
            }
        }*/
    }
}
