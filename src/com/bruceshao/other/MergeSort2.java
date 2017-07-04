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
public class MergeSort2
{
    public static void main(String[] args)
    {
        int[] nums = {9, 1, 5, 7, 2, 6, 3, 8, 10, 4};
        nums = mergeSort(nums, 0, nums.length - 1);
        for (int i : nums)
        {
            System.out.print(i + " ");
        }
    }
    
    private static int[] mergeSort(int[] nums, int low, int high)
    {
        int middle = (low + high) / 2;
        if (low < high) // 边界就是两个相等，相等的时候意味着只有一个元素，直接返回即可
        {
            // 排序左侧的部分
            mergeSort(nums, low, middle);
            
            // 排序右侧的部分
            mergeSort(nums, middle + 1, high);
            
            // 经过两次排序之后，nums是一个有序的两个数组了，需要将其进行合并
            mergeArray(nums, low, middle, high);
        }
        return nums;
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
}
