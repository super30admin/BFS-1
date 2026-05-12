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

 // sol 1 - using BFS 
 // Time Complexity - O(n)
 //Space Complexity - O(n)
 /*
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root== null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int size =q.size(); 
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            result.add(li);
        }
        return result;
    }
}
*/

//sol-2 Using DFS
// Time Complexity O(n)
// Space Complexity O(n)
class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        if(root==null) return;
        //logic
        if(level==result.size()){
            result.add(new ArrayList<>());
        }
        List<Integer> li =result.get(level); 
        //result.get(level).add(root.val); // if we directly add the value it will be by reference and not val --> ds inside a ds acts like pointer 
        li.add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}