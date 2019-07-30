// Time Complexity :O(n) -> number of nodes
// Space Complexity :O(2ˆh) -> maximum height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Approach:
// 1. push the root element to the queue .
// 2. Calculate size of queue and push left and right nodes of the polled element into queue . 
// Do this x times(x is size of stack before adding left and right nodes ). 
// 3. Now again calculate size and repeat above process . Do this till all elements are covered or queue is empty finally.
public class levelOrderBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)    return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> templist = new ArrayList<>();
            int size = queue.size();
            while(size>0){
                TreeNode current = queue.poll();
                if(current!=null)   templist.add(current.val);
                if(current.left!=null)  queue.add(current.left);
                if(current.right!=null) queue.add(current.right);
                size--;
            }
            result.add(templist);
        }
        return result;
    }
}
