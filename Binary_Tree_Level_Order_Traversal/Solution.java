// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use BFS approach to traverse the tree and create indivisual lists to store each level in final result list.
 * During each poll operation, we check size of queue, which tells us how many elements are there in current level.
 * So we run a loop from 0 to no of elements in current level - 1 and store current level elements in an temp list.
 * During each iteration of for loop we add children of current processing node in queue to proecess next level if they are not null
 * At the end of for loop, we add temp list of current level to final result list.
*/


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
    //List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(q.isEmpty() == false){
            int size = q.size();
            for(int i = 0; i < size;i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null)q.add(curr.left);
                if(curr.right != null)q.add(curr.right);
            }
            result.add(new ArrayList<>(temp));
            temp.clear();
        }
        // result = new ArrayList<>();
        // int level = 0;
        // dfs(root, 0);
        return result;
    }
    
//     private void dfs(TreeNode root, int level){
//         //base case
//         if(root == null)return;
        
//         //logic
//         if(result.size() <= level){
//             result.add(level, new ArrayList<>());
//         }
//         result.get(level).add(root.val);
//         dfs(root.left, level + 1);
//         dfs(root.right, level + 1);
//     }
}