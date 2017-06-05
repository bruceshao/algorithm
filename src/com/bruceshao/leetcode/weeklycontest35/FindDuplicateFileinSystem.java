/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: FindDuplicateFileinSystem.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月5日, Create
 */
package com.bruceshao.leetcode.weeklycontest35;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class FindDuplicateFileinSystem
{

    /**
     * Given a list of directory info including directory path, and all the files with contents in this directory,
     *  you need to find out all the groups of duplicate files in the file system in terms of their paths.
        A group of duplicate files consists of at least two files that have exactly the same content.
        A single directory info string in the input list has the following format:
        "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
        It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, 
        respectively) in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. 
        If m = 0, it means the directory is just the root directory.
        The output is a list of group of duplicate file paths. For each group, 
        it contains all the file paths of the files that have the same content. 
        A file path is a string that has the following format:
        "directory_path/file_name.txt"
     * Example 1:
        Input:
        ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
        Output:  
        [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
     * 
     */
    public static void main(String[] args)
    {
        List<List<String>> list = findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"});
        for (List<String> list2 : list)
        {
            System.out.println(list2);
        }
    }
    
    public static List<List<String>>  findDuplicate(String[] paths) {
        List<List<String>> list = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String string : paths)
        {
            String[] pathOnes = string.split(" ");
            String pathOne = pathOnes[0];
            String key = "";
            if (pathOnes.length > 1)
            {
                for (int i = 1; i < pathOnes.length; i++)
                {
                    String[] path = pathOnes[i].split("\\.txt");
                    key = path[1];
                    String finalPath = pathOne + "/" + path[0] + ".txt";
                    if (!map.containsKey(key))
                    {
                        map.put(key, new ArrayList<String>());
                    }
                    map.get(key).add(finalPath);
                }
            }
            else
            {
                if (!map.containsKey(key))
                {
                    map.put(key, new ArrayList<String>());
                }
                map.get(key).add(pathOne);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet())
        {
            if (entry.getValue().size() > 1)
            {
                list.add(entry.getValue());
            }
        }
        return list;
    }
}
