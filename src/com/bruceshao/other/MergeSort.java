/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: MergeSort.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月26日, Create
 */
package com.bruceshao.other;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class MergeSort
{
    public static void main(String[] args)
    {
        int[] nums1 = {1, 4, 5};
        int[] nums2 = {2, 7, 9};
        int[] nums = mergeArray(nums1, nums2);
        for (int i : nums)
        {
            System.out.println(i);
        }
        mergeArray(new int[]{1, 4, 5, 2, 7, 9}, 0, 2, 5);
    }
    
    /**
     * 其中low是起始，middle是第一个数组的终止，middle+1是下个数组的起始，high是下个数组的结束
     * 即有两个排好序的数组nums[low...middle]和nums[middle+1...high]
     * @param nums
     * @param low
     * @param middle
     * @param high
     */
    private static void mergeArray(int[] nums, int low, int middle, int high)
    {
        int[] temp = new int[high - low + 1]; // 创建一个临时的数组，等填充完此数组之后再将结果赋给nums
        
        int i = low, j = middle + 1, k = 0;
        
        while (i <= middle && j <= high)
        {
            if (nums[i] < nums[j])
            {
                temp[k++] = nums[i++];
            }
            else
            {
                temp[k++] = nums[j++];
            }
        }
        // 此时可能还存在问题需要处理：例如first还剩下或者second还剩下
        if (i == middle + 1) // first已经遍历到头了，剩下的都是second
        {
            while (j <= high)
            {
                temp[k++] = nums[j++];
            }
        }
        else
        {
            while (i <= middle)
            {
                temp[k++] = nums[i++];
            }
        }
        
        // 重新赋给nums数组
        for (int n = 0; n < temp.length; n++)
        {
            nums[n + low] = temp[n];
        }
        
    }
    
    private static int[] mergeArray(int[] first, int[] second)
    {
        if (first == null)
        {
            return second;
        }
        if (second == null)
        {
            return first;
        }
        int[] answers = new int[first.length + second.length];
        
        // 合并两个数组的方式比较简单
        // 1、同时遍历两个数组，对两个数组分别定义两个指针开始跑
        // 2、比较两个指针对应大小的值，然后插入到新的数组（注意新数组也需要一个指针）
        int i = 0, j = 0, k = 0;
        
        while (i < first.length && j < second.length)
        {
            if (first[i] < second[j])
            {
                answers[k++] = first[i++];
            }
            else
            {
                answers[k++] = second[j++];
            }
        }
        // 此时可能还存在问题需要处理：例如first还剩下或者second还剩下
        if (i == first.length) // first已经遍历到头了，剩下的都是second
        {
            while (j < second.length)
            {
                answers[k++] = second[j++];
            }
        }
        else
        {
            while (i < first.length)
            {
                answers[k++] = first[i++];
            }
        }
        return answers;
    }
}
