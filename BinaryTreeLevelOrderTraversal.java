// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null ) return new ArrayList();
        List<List<Integer>> list = new ArrayList();
        Deque<TreeNode> q =new LinkedList();
        q.offer(root);
        
        
        while(!q.isEmpty()){
            int size= q.size();
            
            List<Integer> temp = new ArrayList();
            
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            list.add(temp);
        }
        return list;
    }
}
