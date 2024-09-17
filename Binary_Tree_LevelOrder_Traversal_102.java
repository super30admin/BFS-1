//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class Binary_Tree_LevelOrder_Traversal_102 {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        
//        List<List<Integer>> result = new ArrayList<>();
//        if(root == null)
//            return result;
//        
//        Queue<TreeNode> bfsQueue = new LinkedList<>();
//        bfsQueue.add(root);
//        
//        while(!bfsQueue.isEmpty())
//        {
//            int size = bfsQueue.size();
//            List<Integer> temp = new ArrayList<>();
//            for(int i = 0; i < size; i++)
//            {
//                TreeNode node = bfsQueue.poll();
//                temp.add(node.val);
//                if(node.left != null)
//                    bfsQueue.add(node.left);
//                if(node.right != null)
//                    bfsQueue.add(node.right);
//            }
//            result.add(temp);
//        }
//        return result;
//    }
	List<List<Integer>> result = new ArrayList<>();
 public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null)
            return result;
        dfs(root, 0);
        return result;
    }
 
 	private void dfs(TreeNode root, int level)
 	{
 		if(root == null)
 			return;
 		if(level == result.size())
	 		result.add(new ArrayList<>());
 		result.get(level).add(root.val);
 		
 		dfs(root.left, level + 1);
 		dfs(root.right, level + 1);	
 	}
}
