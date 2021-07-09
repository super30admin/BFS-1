// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //DFS solution
        List<List<Integer>> result = new ArrayList<>();
        //base case
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> li = new ArrayList<>();
            int count = q.size();
            for(int i=0; i<count; i++){
            TreeNode node = q.poll();
            li.add(node.val);
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
                
            }
            result.add(li);
        }
        return result;
        
    }
}