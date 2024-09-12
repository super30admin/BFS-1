// Time Complexity :  O(N)
// Space Complexity : O(N) // n by 2
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<Integer>();
        if(root == null) return res;
        helper(root);
        return res;
    }
    public void helper(TreeNode root){
//         if(root == null) return; 
//         if(level == res.size()) res.add(root.val);
        
        
//         helper(root.right, level + 1);
//         // System.out.println(root.val);
//         helper(root.left, level + 1);
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int last = root.val;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int size = q.size();
            for(int i = 0; i < size;i++){
                last = node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(last);
        }
        
    }
}