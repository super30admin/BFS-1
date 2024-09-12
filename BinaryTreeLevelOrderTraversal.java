// Time Complexity : O(n)
// Space Complexity : O(height)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

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
        return helper(root,0, new LinkedList<List<Integer>>());
    }
    
    public List<List<Integer>> helper(TreeNode root, int height, List<List<Integer>> result){
        if(root==null)
            return result;
        if(result.size()==height)
            result.add(new LinkedList<Integer>());
        result.get(height).add(root.val);
        helper(root.left,height+1,result);
        helper(root.right,height+1,result);
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(2^height)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

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
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty() && q.peek()!=null){
            int size=q.size();
            List<Integer> tmpList = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode tmp = q.poll();
                tmpList.add(tmp.val);
                if(tmp.left!=null)
                    q.add(tmp.left);
                if(tmp.right!=null)
                    q.add(tmp.right);
            }
            result.add(new LinkedList<>(tmpList));
        }
        return result;
    }
}