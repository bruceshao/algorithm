/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: TwoSum_1.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月5日, Create
 */
package com.bruceshao.leetcode.problems;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class TwoSum_1
{
    public static void main(String[] args)
    {
        int[] answers = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i : answers)
        {
            System.out.println(i);
        }
    }
    
    public static int[] twoSum(int[] nums, int target)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
