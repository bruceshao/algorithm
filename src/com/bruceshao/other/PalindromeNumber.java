/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: PalindromeNumber.java
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
public class PalindromeNumber
{
    public static void main(String[] args)
    {
        // 回文数
        int palindromeNumber = 121;
        System.out.println(isPalindromeNumber(palindromeNumber));
    }
    
    private static boolean isPalindromeNumber(int x)
    {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        
        int t = x, l = 0;
        while (t >= 10)
        {
            t /= 10;
            l++;
        }
        // 此时获取到的l即是最大的10进制的值
        // 注意规律：12321    前面1=(12321/10000)(=1
        
        
        int i = 1;
        while (l >= i)
        {
            int a = x / (int)Math.pow(10, l--);
            int b = x % (int)Math.pow(10, i++);
            if (a != b)
            {
                return false;
            }
        }
        return true;
    }
}
