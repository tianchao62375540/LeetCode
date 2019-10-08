package com.leetcode.java.suanfa;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/7 12:58
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */

/**
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code0003 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        String strResult = "";
        int result = 0;
        for(int i=0;i<chars.length;i++){
            if(result>=(s.length()-i)){
                return result;
            }
            for(int j = i;j<chars.length;j++){
                if(j+1==chars.length||s.substring(i,j+1).indexOf(chars[j+1]+"")!=-1){
                    int temp = j+1-i;
                    if(temp>result){
                        result = temp;
                        strResult = s.substring(i,j+1);
                    }
                    break;
                }
            }
        }
        System.out.println(strResult);
        return result;
    }

    public static void main(String[] args) {
        Code0003 code0003 = new Code0003();
        int abc = code0003.lengthOfLongestSubstring("abcdefg");
        System.out.println(abc);
      /*  char[] chars = "abcdea".toCharArray();
        for(char c:chars){
            System.out.println(c);
        }*/
    }
}

