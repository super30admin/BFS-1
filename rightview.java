// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null){		// base case
            return result;
        }
        q.add(root);	// add the root and recursively go through the tree
        rightside(q, result);
        
        return result;
    }
    
    private void rightside(Queue<TreeNode> queue, List<Integer> list){
        
        List<Integer> res = new ArrayList<>(); // new list is created for every level
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode temp = null;
        
        while(!queue.isEmpty()){		// while the queue is empty, remove the first element and find its children and add it to new queue inside the recursive function
            temp = queue.poll();
            res.add(temp.val);
            
             if(temp.left != null){		// add left child if not null
                q.add(temp.left);
            }
            
            if(temp.right != null){		// add right child if not null
                q.add(temp.right);
            }
            
            System.out.println(temp.val);
        }
        result.add(temp.val);		// before moving to the next level, we know the last element is the right side view of the tree, add it to the list
        
        
        while(!q.isEmpty()){		// recursively go through the tree with new list
            rightside(q, res);
        }
    }
}