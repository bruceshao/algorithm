/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: MatrixMultiplication.java
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
public class MatrixMultiplication
{
    // 矩阵乘法
    /**
     * {1 2} * {2 3} = {2 6}
     * {3 0}   {3 4}   {9 0}
     * @param args
     */
    public static void main(String[] args)
    {
        // 我们用二维数组代表矩阵
        int[][] m = new int[2][2];
        m[0][0] = 1;
        m[0][1] = 2;
        m[1][0] = 3;
        m[1][1] = 4;
        
        int[][] n = new int[2][2];
        n[0][0] = 1;
        n[0][1] = 2;
        n[1][0] = 3;
        n[1][1] = 4;
        
        int[][] k = matrixMultiplication(m, n);
        for (int i = 0; i < k.length; i++)
        {
            int[] k2 = k[i];
            for (int j = 0; j < k2.length; j++)
            {
                System.out.print(k2[j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int[][] matrixMultiplication(int[][] m, int[][] n)
    {
        int[][] k = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++)
        {
            int[] m2 = m[i];
            int[] n2 = n[i];
            int[] k2 = k[i];
            for (int j = 0; j < m2.length; j++)
            {
                k2[j] = m2[j] * n2[j];
            }
        }
        return k;
    }
}
