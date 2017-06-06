/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: AddTwoNumbers_2.java
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
public class AddTwoNumbers_2
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {

    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1, node2 = l2;
        int temp = 0;
        ListNode listNode = new ListNode(0);
        ListNode rootNode = listNode;
        while ((node1 != null || node2 != null) || temp != 0)
        {
            int val = (node1 == null ? 0 : node1.val) + (node2 == null ? 0 : node2.val) + temp;
            temp = val / 10;
            listNode = listNode.next = new ListNode(val % 10);
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }
        return rootNode.next;
    }

}
