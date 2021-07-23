//TC: O(N)
//SC: O(N)
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
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        
        dfs(root, 0);
        return result;
        
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if(root == null)
//             return result;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()) {
//             int sz = queue.size();
//             List<Integer> list = new ArrayList<>();
//             for(int i=0; i<sz; i++) {
//                 TreeNode curr = queue.poll();
//                 list.add(curr.val);
//                 if(curr.left != null) 
//                     queue.add(curr.left);
//                 if(curr.right != null)
//                     queue.add(curr.right);
//             }
//             result.add(list);
//         }
//         return result;
    }
    
    private void dfs(TreeNode root, int level) {
        if(root == null)
            return;
        
        if(result.size() == level)
            result.add(new ArrayList<>());
        
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}







