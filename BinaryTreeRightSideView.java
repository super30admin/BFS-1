// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach




class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList();
        Deque<TreeNode> q = new LinkedList();
        List<Integer> result = new ArrayList();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            int value=0;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                value=node.val;
                if(node.left != null ) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
           result.add(value);
        }
        return result;
    }
}
