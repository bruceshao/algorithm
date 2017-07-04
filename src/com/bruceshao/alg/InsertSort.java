/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: InsertSort.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年7月4日, Create
 */
package com.bruceshao.alg;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class InsertSort
{
    public static void main(String[] args)
    {
        // 插入排序
        int[] nums = insertSort(new int[]{2, 5, 8, 1, 9, 10, 3, 4});
        for (int i : nums)
        {
            System.out.print(i + " ");
        }
    }
    
    public static int[] insertSort(int[] nums)
    {
        /**
         * 1、先拿出一个数字；
         * 2、然后将此数字插入到合适的位置
         * 3、此处合适的位置指的是按照顺序排序后的结果，注意需要做交换的操作
         */
        for (int i = 2; i < nums.length; i++)
        {
            int key = nums[i];
            int j = i - 1;
            while (j > 0 && nums[j] > key)
            {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }
}
