// Time Complexity : O(n)  
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0; i<size;i++){
            TreeNode curr = queue.poll();
            li.add(curr.val);
            if(curr.left!=null) queue.add(curr.left);
             if(curr.right!=null) queue.add(curr.right);
        }
        result.add(li);
        }
        return result;
    }
}