/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: LengthOfLongestSubstring_3.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月5日, Create
 */
package com.bruceshao.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class LengthOfLongestSubstring_3
{
    public static void main(String[] args)
    {
        StringBuilder sbuilder = new StringBuilder();
        for(int i = 0 ; i < 100000; i++)
        {
            sbuilder.append("abcbajagjhfakhfkashacnjklopew1234567890!#$#^&fkahfjkgajgfjagfjagfjagjfhgjashfgjahgfjhasgfjhsagfjhagsfjcbddddsssdsdadad");
        }
        String s = sbuilder.toString();
        long time1 = System.currentTimeMillis();
        System.out.println("我的答案：" + lengthOfLongestSubstring_1(s));
        long time2 = System.currentTimeMillis();
        System.out.println("标准答案：" + lengthOfLongestSubstring_2(s));
        long time3 = System.currentTimeMillis();
        System.out.println("我花费的时间：" + (time2 - time1));
        System.out.println("标准答案花费的时间：" + (time3 - time2));
    }
    
    public static int lengthOfLongestSubstring_1(String s) {
        int i = 0, j = 0, max = 0, size = 0;
        int[] set = new int[256];
        
        while (j < s.length()) {
            if (set[s.charAt(j)] != 1) {
                set[s.charAt(j++)] = 1;
                size++;
                max = Math.max(max, size);
            } else {
                size--;
                set[s.charAt(i++)] = 0;
            }
        }
        
        return max;
    }
    
    public static int lengthOfLongestSubstring_2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        
        return max;
    }
}
