// Time Complexity : O(n) number of nodes in tree
// Space Complexity : O(n/2) -> O(n) in worst case q will have all the nodes at last level of tree and a tree no of nodes on last level =n/2
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//. 1. Using BFS

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
         ArrayList<List<Integer>> arraylist = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return arraylist;
        q.add(root);
        while(!q.isEmpty())
        {
            ls = new ArrayList<>();
            int size = q.size();
            TreeNode node = null;
            for(int i = 0 ; i < size ; i++)
            {
                 node = q.poll();
                if(node !=null)
                ls.add(node.val);
                
                 if(node != null && node.left != null)
                q.add(node.left);
                 if(node != null && node.right != null)
                q.add(node.right);
            }
            
            arraylist.add(ls);
           
        }
        
        return arraylist;
    }
}