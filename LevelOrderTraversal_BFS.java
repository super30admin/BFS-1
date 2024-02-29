//https://leetcode.com/problems/binary-tree-level-order-traversal/
package week5.day1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal_BFS {
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            while(size>0){
               TreeNode curr = q.poll();
               list.add(curr.val); 
               if(curr.left!=null)
                    q.add(curr.left);
               if(curr.right!=null)
                    q.add(curr.right);
               size--;
            }
            result.add(list);
        }
    return result;
    }
    
    public static void main(String[] args) {
    	// Creating the tree [3,9,20,null,null,15,7]
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode root = new TreeNode(3, node9, node20);

        // Calling levelOrder method to perform level order traversal
        List<List<Integer>> traversalResult = levelOrder(root);

        // Printing the result
        for (List<Integer> level : traversalResult) {
            System.out.println(level);
        }
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
