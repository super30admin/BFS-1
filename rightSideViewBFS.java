// Time Complexity :O(n) n is the nodes of the tree
// Space Complexity :O(n/2) n is then is the nodes of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int last =-1;
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                last = curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            result.add(last);
        }
        
        return result;
    }
}