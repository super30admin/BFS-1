// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        
        //create queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            //calculate size
            int sz = queue.size();
            
            List<Integer> list = new ArrayList<>();
            //iterate through level
            for(int i = 0; i < sz; i++){
                //poll from queue
                TreeNode curr = queue.poll();
                
                //add to list
                list.add(curr.val);
                //add left child
                if(curr.left != null)
                    queue.add(curr.left);
                //add right child
                if(curr.right != null)
                    queue.add(curr.right);
            }
            
            result.add(list);
        }
        
        return result;
    }
}