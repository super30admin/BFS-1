
/*
Time complexity of two pointers approach [Optimal] - O(N)
Space complexity of two pointers approach [Optimal] - O(N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class BinaryTreeLevelOrderTraversal_LC_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null) return result;
        queue.offer(root);     // offer() -  inserts the specified element into the queue
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> list = new LinkedList<Integer>();
            for(int i=0;i<level;i++){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }
            result.add(list);
        }
        return result;
    }
}


 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
