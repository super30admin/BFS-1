// Time Complexity :  O(N)
// Space Complexity : O(N) // n by 2
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0 ;i< size;i++){
                TreeNode node = q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                temp.add(node.val);               
            }
            res.add(temp);
        }
        return res;
    }
}