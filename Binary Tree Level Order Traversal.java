// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        result = new ArrayList<>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level =  new ArrayList<>();
            for( int i=0;i<size;i++){
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            result.add(level);

        }
        return result;
    }
}
