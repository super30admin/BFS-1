/**
 * Time Complexity: O(n^2)
 * Space Complexity : O(n) - 2 extra  queues used
 * Idea:
 * 1. At each node add children to levelOrderquque.
 * 2. Copy elements from levelQueue to main queue until level queue is empty
 * 3. Repeat until main queue is empty
 * Leetcode: Yes
 */


import java.util.*;

class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class LevelOrderTraversal {
   
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();

        queue.add(root);
        temp.add(root.val);
        result.add(temp);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
          // System.out.print(curr.val + " ");

           if(curr.left != null)
            levelQueue.add(curr.left);
            
            if(curr.right != null)
                levelQueue.add(curr.right);
            
            if(queue.isEmpty() && !levelQueue.isEmpty()){
                queue = new LinkedList<>(levelQueue);
                temp = new ArrayList<>();
                while(!levelQueue.isEmpty()){
                    temp.add(levelQueue.poll().val);
                }                
                result.add(temp);
            }
        }

        return result;
    }
}

class Solution {    
    public static void main(String[] args){
        System.out.println("Level Order Traversal");
        LevelOrderTraversal obj = new LevelOrderTraversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

       System.out.println(obj.levelOrder(root));
    }
}