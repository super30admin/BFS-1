/**
 * Time Complexity: O(n^2)
 * Space Complexity : O(n) - 2 extra  queues used
 * Idea:
 * 1. At each node add children to levelOrderquque.
 * 2. Copy elements from levelQueue to main queue until level queue is empty. 
 * 3. Keep track of the findal element in this level queue which is the right most element. Repeat until main queue is empty
 * Leetcode: Yes
 */

import java.util.*;

class TreeNode {
       int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

class RightViewBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        

        queue.add(root);
        result.add(root.val);
        //result.add(temp);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
          // System.out.print(curr.val + " ");

           if(curr.left != null)
             levelQueue.add(curr.left);
            
            if(curr.right != null)
                levelQueue.add(curr.right);
            
            if(queue.isEmpty() && !levelQueue.isEmpty()){
                queue = new LinkedList<>(levelQueue);                
                int rightValue = Integer.MAX_VALUE;
                while(!levelQueue.isEmpty()){
                    rightValue = levelQueue.poll().val;
                }                
                result.add(rightValue);
            }
        }

        return result;

    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("Right Side View Binary Tree");
        RightViewBinaryTree obj = new RightViewBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        //root.right.right = new TreeNode(7);

        System.out.println(obj.rightSideView(root));

    }
}