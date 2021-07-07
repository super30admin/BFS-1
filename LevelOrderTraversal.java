// Time Complexity :O(N)
// Space Complexity :O(2 raise to h) - Since at a given point of time all memebers of each level will be in the queue
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
              
        if(root==null)return result;
        
          q.add(root); //BFS search
        
        while(!q.isEmpty())
        {
            int count = q.size(); //The size is the cut off for adding to the list
            
            List<Integer> list = new ArrayList<>();
            
            for(int i =0 ;i<count;i++)
            {
                TreeNode node = q.poll();
                list.add(node.val); //adding that many to the list and and adding to quueue as well
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
                
            }
            
            result.add(list); //adding to the list
        }
        
        return result;
    }
}
