// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// Iterative BFS

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> small = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode aux = q.poll();
                if(aux.left !=null) q.add(aux.left);
                if(aux.right !=null) q.add(aux.right);
                small.add(aux.val);
            }
            res.add(small); 
        }
        return res;
    }


    /**
    Recursive DFS
    Time: O(n) Space O(n)
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return res;
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int level){
        if(root==null)
            return;
        
        if(level == res.size()){
            res.add(new ArrayList<>());
        }
        
        res.get(level).add(root.val);
        
        if(root.left != null){
            helper(root.left, level +1);
        }
        if(root.right != null){
            helper(root.right, level +1);
        }  
    }
}