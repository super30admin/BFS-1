// Time Complexity :O(n) n is the nodes of the tree
// Space Complexity :O(n/2) n is then is the nodes of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {    
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                
            }
            result.add(list);
        }
        return result;
        
    }
}