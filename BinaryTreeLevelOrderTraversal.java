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
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
//BFS
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> levelOrder(TreeNode root) {
        // result = new ArrayList<>();
        // if(root == null)
        //     return result;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
        
//         while(!q.isEmpty()){
//             int size = q.size();
//             List<Integer> li = new ArrayList<>();
            
//             for(int i = 0; i < size; i++){
//                 TreeNode cur = q.poll();
//                 li.add(cur.val);
//                 if(cur.left != null)
//                     q.add(cur.left);
//                 if(cur.right != null)
//                     q.add(cur.right);
//             }
            
//             result.add(li);
//         }
//         return result;
//     }
// }

// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
//DFS
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        
        dfs(root, 0);
        
        return result;
    }
    
    private void dfs(TreeNode root, int lvl){
        if(root == null)
            return;
        if(result.size() == lvl)
            result.add(new ArrayList<>());
        result.get(lvl).add(root.val);
        
        dfs(root.left, lvl + 1);
        dfs(root.right, lvl + 1);
    }
}
