/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: TreeNode.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年7月3日, Create
 */
package com.bruceshao.other;

import java.util.List;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class TreeNode
{
    public List<TreeNode> childrens;
    
    public String val;

    public TreeNode(String val)
    {
        this.val = val;
    }
}
