// Time Complexity : O(V+E)
// Space Complexity : O(n) n is max diameter or width of all levels
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root == null) 
            return new ArrayList<List<Integer>>(); 
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> l=new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                TreeNode temp=q.poll();
                l.add(temp.val);
             if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
            }
            res.add(l);
        }return res; 
        }   
    }