// https://leetcode.com/problems/binary-tree-right-side-view/
// Time Complexity :O(n) -> number of nodes
// Space Complexity :O(2ˆh) -> maximum height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach:
// 1. push the root element to the queue .
// 2. Calculate size of queue and poll element from queue . Now add first polled value to the list .
//    Now add polled root's right and left nodes to the queue . Now pop elements from queue x times(x is size of queue before adding value to list)
//    and add corresponding right nodes and left nodes for each popped element.  
// 3. Now again calculate size and repeat above process . Do this till all elements are covered or queue is empty finally.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideViewBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null)    return result;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean b = true;
            while(size>0){
                TreeNode current = queue.poll();
                if(b){
                    result.add(current.val);
                    b = false;
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
                if(current.left!=null){
                    queue.add(current.left);
                }
                size--;
            }
        }
        return result;
    }
}
