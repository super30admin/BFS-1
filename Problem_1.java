// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root==null ) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(q.isEmpty()){
            int size= q.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
                currLevel.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                 if(curr.right != null) q.add(curr.right);
            }
            
            result.add(currLevel);
        }
        
        return result;
    }
}