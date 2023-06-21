// Time Complexity - O(n) -- as we traverse through all the elements -- don't get confused by seeing 2 loops(1 while and for loop inside) its still O(n) as finally we traverse 'n' nodes
// Space Complexity - O(n) -- as list has all the elements

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
    // DFS Implementation
    /* List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int level){
        // base condition
        if(root == null) return;
        // logic
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
    } */

    // BFS Implementation
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            // level processing
            List<Integer> li = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(li);
        }
        return result;
    }

}