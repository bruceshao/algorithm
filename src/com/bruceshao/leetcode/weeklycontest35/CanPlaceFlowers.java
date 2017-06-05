/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: CanPlaceFlowers.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月5日, Create
 */
package com.bruceshao.leetcode.weeklycontest35;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class CanPlaceFlowers
{

    /**
     * 
     * Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
     * However, flowers cannot be planted in adjacent plots - 
     *     they would compete for water and both would die.

     * Given a flowerbed (represented as an array containing 0 and 1, 
     *     where 0 means empty and 1 means not empty), and a number n, 
     * return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
     * 
     * Example 1:
     * Input: flowerbed = [1,0,0,0,1], n = 1
     * Output: True
     * Example 2:
     * Input: flowerbed = [1,0,0,0,1], n = 2
     * Output: False
     * 
     * 中文注释：输入一个数组，数组中的0表示的是为空，意思就是说可以种花，1表示已经种上了花，言外之意是不可以种花
     * Tips：
     * 1）如果两个1之间连续的0的个数超过3个才可以种花；
     * 2）3-》1，4-》1,5-》2,6-》2，规律
     * 3）一定要注意开头和结尾
     */
    public static void main(String[] args)
    {
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
    
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int canNums = 0, oneIndex = -2;
        double beiShu = 2d;
        for (int i=0; i<flowerbed.length; i++)
        {
            if (flowerbed[i] == 1)
            {
                if (oneIndex == -2)
                {
                    if (i >= 2)
                    {
                        canNums += ((i - oneIndex - 4)/beiShu + 1);
                    }
                }
                else
                {
                    canNums += ((i - oneIndex - 4)/beiShu + 1);
                }
                oneIndex = i;
            }
        }
        if (oneIndex != flowerbed.length - 1 && (flowerbed.length - 1 - oneIndex >= 2)) // 最后值为0
        {
            canNums += ((flowerbed.length - oneIndex - 3)/beiShu + 1);
        }
        return (canNums >= n) ? true : false;
    }

}
