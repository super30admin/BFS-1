// Time Complexity :O(N) 
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach: Traverse the tree in Bfs and add the elemts to temporary list and once 
//reaching the end of that level add this temp list to result.
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
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;                    
            queue.add(root);
            queue.add(null);
        List<Integer> t = new LinkedList<>();
        while(!queue.isEmpty()){
            TreeNode temp=queue.remove();
            if(temp==null ){
                result.add(t);
                t= new LinkedList<>();
                if(queue.isEmpty())
                    break;
                else
                    queue.add(null);
                continue;
                }            
            t.add(temp.val);
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        return result;
    }
}