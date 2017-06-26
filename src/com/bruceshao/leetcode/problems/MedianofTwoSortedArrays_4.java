/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: MedianofTwoSortedArrays_4.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月6日, Create
 */
package com.bruceshao.leetcode.problems;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class MedianofTwoSortedArrays_4
{
    public static void main(String[] args)
    {
        int[] nums1 = {1, 3, 5, 8, 10, 12, 16}, nums2 = {2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int temp = 0, m = nums1.length, n = nums2.length;
        int i = 0, j = 0;
        if ((m + n) % 2 != 0) // 奇数
        {
            int medianIndex = (m + n)/ 2 + 1;
            int size = 0;
            while (i < m || j < n)
            {
                while ((i < m) && (nums2[j] > nums1[i]) && (temp < medianIndex))
                {
                    size = nums1[i];
                    i++;
                    temp++;
                }
                if (temp == medianIndex)
                {
                    break;
                }
                while ((j < n) && ((nums1[i] > nums2[j])) && (temp < medianIndex))
                {
                    size = nums2[j];
                    j++;
                    temp++;
                }
                if (temp == medianIndex)
                {
                    break;
                }
            }
            return size;
        }
        
        return 0;
    }
}
