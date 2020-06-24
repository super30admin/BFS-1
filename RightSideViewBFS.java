// Time Complexity : O(n)
//Space Complexity : O(W)  ir O(N) he width of the tree 
//Did this code successfully run on Leetcode : Yes
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int last = -1;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr= q.poll();
                last = curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(last);
            
        }
        
        return result;
    }
}