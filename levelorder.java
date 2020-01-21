// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }*/
 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        
        if(root == null){	// base case
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();		// using a queue as the data structure 
        queue.add(root);	// add the root and recursively go through the tree
        LevelOrder(result, queue);	
        
    return result;
    }
    
    private void LevelOrder(List<List<Integer>> result, Queue<TreeNode> q){
        
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        while(!q.isEmpty()){		// while the queue is empty, remove the first element and find its children and add it to new queue inside the recursive function
            TreeNode node = q.poll();
            res.add(node.val);		// new list is created for every level
            
            if(node.left != null){		// add left child if not null
                queue.add(node.left);
            }
            
            if(node.right != null){		// add right child if not null
                queue.add(node.right);
            }
        }
        result.add(res);		// add the level traversed elements to the original list
        if(!queue.isEmpty()){	// recursively call the function using the queue and final list to traverse through all the elements
            LevelOrder(result, queue);
        }
    
    }
    
}