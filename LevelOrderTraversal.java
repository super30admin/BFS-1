// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                
                if(node.left != null) {
                    queue.add(node.left);
                }
                
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        
        return result;
    }
}