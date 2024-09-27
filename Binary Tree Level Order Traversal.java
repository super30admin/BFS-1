/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//T: O(n)
//S: O(n)
// Standard Level order traversal using queue, implemented using LinkedList.

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    
        List<Integer> individualList = new LinkedList<Integer>();
        List<List<Integer>> finalList = new LinkedList<List<Integer>>();
        
        if(root == null)    return finalList;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(root);
        
        while(q.size() > 0){
            
            int len = q.size();
            
            while(len > 0){
                
                TreeNode temp = q.remove();
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                individualList.add(temp.val);
                len--;
            }
            
            finalList.add(individualList);
            individualList =  new LinkedList<Integer>();
        }
        
        return finalList;
    }
}