// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    
    //BFS
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List < List < Integer > > ans = new LinkedList();
        if(root==null) return ans;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        //BFS
        while(!q.isEmpty()) {
            
            int s = q.size();
            List < Integer > temp = new LinkedList();
            for(int i = 0;i<s;i++) {
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            
            ans.add(temp);
        }
        return ans;
    }
}
