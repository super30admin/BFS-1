// Time Complexity : O(n) number of nodes
// Space Complexity : O(n) highesh width of the binary tree which can be n/2
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
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
     }
 }

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new java.util.LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i< size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                temp.add(curr.val);
            }
            result.add(temp);
        }
        return result;
    }
}