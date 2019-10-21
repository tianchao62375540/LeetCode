package com.leetcode.java.construct.queue;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/21 13:28
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 采用BFS广度优先搜索
 */
public class QuestionDaoyuNumTest {
    private static char[][] all = new char[][] {
            { '1', '1', '1', '1', '0' },
            { '1', '1', '0', '1', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '0', '0', '0' }
    };
    //int[] dx={0,1,0,-1};
    //int[] dy={1,0,-1,0};

    public static void main(String[] args) {
        QuestionDaoyuNumTest questionDaoyuNumTest = new QuestionDaoyuNumTest();
        int i = questionDaoyuNumTest.numIslands(all);
        System.out.println(i);
    }
    public int numIslands(char[][] grid){
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        int count = 0;
        int row = grid.length;

        if(row==0){
            return count;
        }
        int col = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    //chu队
                    queue.offer(i);
                    queue.offer(j);
                    grid[i][j]='0';
                    while (!queue.isEmpty()){
                        int curX = queue.poll();
                        int curY = queue.poll();

                        for(int index=0;index<dx.length;index++){
                            //出队
                            int xx = dx[index]+curX;
                            int yy = dy[index]+curY;
                            if(xx<0||xx>=row||yy<0||yy>=col){
                                continue;
                            }
                            if(grid[xx][yy]=='1'){
                                queue.offer(xx);
                                queue.offer(yy);
                                grid[xx][yy]='0';
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

}
