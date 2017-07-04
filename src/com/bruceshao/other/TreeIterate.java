/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: TreeIterate.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年7月3日, Create
 */
package com.bruceshao.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class TreeIterate
{
    public static void main(String[] args)
    {
        TreeNode cd1 = new TreeNode("cd1");
        TreeNode cd2 = new TreeNode("cd2");
        TreeNode cd3 = new TreeNode("cd3");
        TreeNode cd4 = new TreeNode("cd4");
        TreeNode note1 = new TreeNode("note1");
        TreeNode note2 = new TreeNode("note2");
        TreeNode root = new TreeNode("root");
        
        List<TreeNode> note1s = new ArrayList<TreeNode>();
        note1s.add(cd1);
        note1s.add(cd2);
        note1.childrens = note1s;
        
        List<TreeNode> note2s = new ArrayList<TreeNode>();
        note2s.add(cd3);
        note2s.add(cd4);
        note2.childrens = note2s;
        
        
        List<TreeNode> roots = new ArrayList<TreeNode>();
        roots.add(note1);
        roots.add(note2);
        root.childrens = roots;
        
        iterate("", root);
    }
    
    private static void iterate(String rootStr, TreeNode root)
    {
        if(root != null)
        {
            System.out.println(rootStr + root.val);
            List<TreeNode> childrens = root.childrens;
            if (childrens != null)
            {
                for (TreeNode treeNode : childrens)
                {
                    iterate(rootStr + root.val, treeNode);
                }
            }
        }
    }
}
