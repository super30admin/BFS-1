
// Time Complexity : O(n)
//Space Complexity : O(n) the width of the tree 
//Did this code successfully run on Leetcode : Yes

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null ) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        
        q.add(root);
       
        while(!q.isEmpty()){
            
             List<Integer> temp = new ArrayList<>();
            
            int size = q.size();
            
            for(int i = 0; i< size; i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(temp);
        }
        
        return result;
        
    }
}