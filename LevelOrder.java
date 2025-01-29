// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
//Put every node in queue
//Determine level by size of queue
//Add array at end of leve;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// * Definition for a binary tree node.
  class TreeNode {
    int val;
     TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> levelInner;
        queue.add(root);
        while(!queue.isEmpty()){
            levelInner = new ArrayList<>();
            int i=queue.size();
            while(i>0){
                TreeNode node = queue.poll();
                if(node!=null){
                    levelInner.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
                i=i-1;
            }
            if(levelInner.size()>0){
                level.add(levelInner);
            }
        }
        return level;
    }
}