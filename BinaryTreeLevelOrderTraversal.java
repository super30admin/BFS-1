// TC: O(N)
// SC: O(1)


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
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> levelList;
        q.add(root);
        while(!q.isEmpty()){
            levelList = new ArrayList<>();
            int size = q.size();
            
            for(int i = 0; i<size;i++){
                TreeNode temp = q.poll();
                levelList.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }                
            }
            result.add(levelList);
            
        }
        
        return result;
        
    }
}






// USING DFS



// TC: O(N)
// SC: O(N)
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
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        dfs(root,0);
        
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        
        
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        
    }
}