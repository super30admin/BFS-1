// Time Complexity : O(n) where n is the number of nodes.
// Space Complexity : O(n) where n is the number of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return ;
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> a = new LinkedList<>();
            for(int i =0;i<size;i++){
                root = q.poll();
                a.add(root.val);
                if(root.left!=null)
                    q.add(root.left);
                if(root.right!=null)
                    q.add(root.right);
            }
            result.add(a);
            a = new LinkedList<>();
        }
        return result;
    }
}