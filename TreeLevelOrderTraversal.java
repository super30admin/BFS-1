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

//BFS Solution
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ll = new ArrayList();
        if(root== null) return ll;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size= q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left!= null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                
            }
            ll.add(temp);
        }
            return ll;
    }
}

//DFS solution 
class Solution {
     List<List<Integer>> ll;
    public List<List<Integer>> levelOrder(TreeNode root) {
        ll = new ArrayList();
        if(root== null) return ll;
        dfs(root,0);
           return ll;
    }
    private void dfs(TreeNode root, int level){
        if(root== null) return;
        if(level== ll.size()) ll.add(new ArrayList<>());
        ll.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right, level+1);
    }
}

Time complexity - O(n)
Space Complexity- O(n)