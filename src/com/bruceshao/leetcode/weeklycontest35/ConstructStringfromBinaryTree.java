/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: ConstructStringfromBinaryTree.java
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
public class ConstructStringfromBinaryTree
{

    /**
     * You need to construct a string consists of parenthesis and integers 
     *     from a binary tree with the preorder traversing way.

     * The null node needs to be represented by empty parenthesis pair "()". 
     * And you need to omit all the empty parenthesis pairs 
     *     that don't affect the one-to-one mapping relationship 
     *     between the string and the original binary tree.
     * 
     * Example 1:
     *   Input: Binary tree: [1,2,3,4]
               1
             /   \
            2     3
           /    
          4     
        
        Output: "1(2(4))(3)"
        
        Explanation: Originallay it needs to be "1(2(4)())(3()())", 
        but you need to omit all the unnecessary empty parenthesis pairs. 
        And it will be "1(2(4))(3)".
        
        
        Example 2:
        Input: Binary tree: [1,2,3,null,4]
               1
             /   \
            2     3
             \  
              4 
        
        Output: "1(2()(4))(3)"
        
        Explanation: Almost the same as the first example, 
        except we can't omit the first parenthesis pair to break the one-to-one mapping relationship 
            between the input and the output.
     * 
     * Tips：这其实就是一棵二叉树，需要对二叉树进行中序遍历即可，剩下的就是对其逻辑的判断
     */
    public static void main(String[] args)
    {
        ConstructStringfromBinaryTree csfbt = new ConstructStringfromBinaryTree();
        System.out.println(csfbt.tree2Str(null));
    }
    
    public String tree2Str(TreeNode t) {
        StringBuilder s = new StringBuilder();
        theInOrderTraversal(s, t);
        return s.toString();
    }
    
    public void theInOrderTraversal(StringBuilder s, TreeNode root)
    {  //中序遍历 
        if (root != null)
        {
            s.append(root.val);
            if (root.left != null || root.right != null)
            {
                if (root.left != null) {
                    s.append("(");
                    theInOrderTraversal(s, root.left);
                    s.append(")");
                }
                else
                {
                    s.append("()");
                }
                if (root.right != null) {
                    s.append("(");
                    theInOrderTraversal(s, root.right);  
                    s.append(")");
                }  
            }
        }
    }
}
