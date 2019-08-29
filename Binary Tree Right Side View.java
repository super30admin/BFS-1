/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
  */

// Recursive Solution
// T: O(N)
// S: O(N)

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
    public List<Integer> rightSideView(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        rightView(root, 0, result);
        return result;
    }
    
    public void rightView(TreeNode root, int depth, List<Integer> result){
        
        if(root == null)    return;
        
        if(depth == result.size())  result.add(root.val);
        
        rightView(root.right, depth + 1, result);
        
        rightView(root.left, depth + 1, result);
    }
}


// Iterative Solution - Just Do level order traveral and take the last node of each level.
// T: O(N)
// S: O(N)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        
        
        if (root == null) return result;
        
        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            
            for (int i=0; i<size; i++){
                
                TreeNode cur = queue.poll();
                if (i == 0) result.add(cur.val);
                
                if (cur.right != null) queue.offer(cur.right);
                
                if (cur.left != null) queue.offer(cur.left);
            }
            
        }
        return result;
    }
}
