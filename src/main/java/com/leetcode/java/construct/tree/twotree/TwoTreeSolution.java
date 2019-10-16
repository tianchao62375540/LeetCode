package com.leetcode.java.construct.tree.twotree;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/16 16:07
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */

/**
 * 树的前序排列，中序排列，后序排列
 */
public class TwoTreeSolution {

    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        //跟
        list.add(root.val);
        //左
        if(root.left!=null){
            preorderTraversal(root.left);
        }
        //右
        if(root.right!=null){
            preorderTraversal(root.right);
        }
        return list;
    }
    public static void main(String[] args) {
        TwoTreeSolution twoTreeSolution = new TwoTreeSolution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(4);
        TreeNode right = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        //treeNode.left = null;
        treeNode.right = right;
        right.left = left2;
        List<Integer> integers = twoTreeSolution.preorderTraversal(treeNode);
        System.out.println(integers);
    }

    /**
     * 前序排列
     * @param root
     * @return
     */
    public List<Integer> beforePreorderTraversal(TreeNode root) {
        //跟
        System.out.println(root.val);
        //左
        if(root.left!=null){
            beforePreorderTraversal(root.left);
        }
        //右
        if(root.right!=null){
            beforePreorderTraversal(root.right);
        }
        return null;
    }
    public List<Integer> middlePreorderTraversal(TreeNode root) {

        //左
        if(root.left!=null){
            middlePreorderTraversal(root.left);
        }
        //跟
        System.out.println(root.val);
        //右
        if(root.right!=null){
            middlePreorderTraversal(root.right);
        }
        return null;
    }

    public List<Integer> afterPreorderTraversal(TreeNode root) {

        //左
        if(root.left!=null){
            afterPreorderTraversal(root.left);
        }

        //右
        if(root.right!=null){
            afterPreorderTraversal(root.right);
        }
        //跟
        System.out.println(root.val);
        return null;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode(int x) { val = x; }
}
