//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Binary_Tree_Right_Side_View_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        
        while(!bfsQueue.isEmpty())
        {
            int size = bfsQueue.size();
            int last = -1;
            for(int i = 0; i < size; i++)
            {
                TreeNode node = bfsQueue.poll();

                if(i == size-1)
                	last = node.val;
                if(node.left != null)
                    bfsQueue.add(node.left);
                if(node.right != null)
                    bfsQueue.add(node.right);
            }
            result.add(last);
        }
        return result;        
    }
}
