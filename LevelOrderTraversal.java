//Problem : 56 - Binary Tree Level Order Traversal
// Time Complexity : O(n), n stands for number of nodes
// Space Complexity : O(H), H stands for height of tree in terms of recursive stack.
//                    In terms of queue-O(n), n -> number of nodes. However as we will be storing max of all nodes at last level. Therefore space comexity will be O(n/2)+something, but constant won't matter thats why O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Can be done using Recursion(DFS) or Queue(BFS). While doing level order traversal using DFS, increment level & pass it on each call. If list size is equal to level, then just create the new List and for adding element in the list use level as an index;

import java.util.*;

class Solution56{
    
    class TreeNode{
         int val;
         TreeNode left,right;
         TreeNode(int val){
             this.val = val;
         }
    }

    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
     
        res = new ArrayList<>();
        
        if(root==null) return res;
        
        /*Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
           
            level = q.size();
            List<Integer> curr = new ArrayList<>();
            
            for(int i=0;i<level;i++){
                root = q.poll();
                curr.add(root.val);
                
                if(root.left!=null) q.offer(root.left);
                
                if(root.right!=null) q.offer(root.right);
                
            }
            
            res.add(curr);
            
        }*/
        
        helper(root,0);
        return res;
    }
    
    private void helper(TreeNode root,int level){
        
        if(root==null) return;
        
        if(level==res.size()){
            res.add(new ArrayList<>());
        }
        
        res.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
        
    }
}