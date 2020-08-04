import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//Approach: Iteration
//1. Here we will go level by level, and keep adding to result by creating a new list on start of every level
//2. Queue size is used to know the number of elements to be processed in that level. once the level is processed, add list to result.
public class Binary_Tree_Level_Order_Traversal {
	List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
//Time Complexity : O(n) where n is the number of nodes in the tree
//Space Complexity : O(n) where n is the nodes 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

//Approach: Recursion
//1. Here the level is maintained in each recursion call. Hence if the level is equal to the size of the result list, we will add a new ArrayList to it. 
//2. since we have the level number attached to each node, we will add them in the result list on the particular index of the level.
//3. After recursion is done, we will return the result.
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result =  new ArrayList<>();
        if(root == null)
            return result;
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode root, int size)
    {
        if(root == null)
            return;
        if(size == result.size())
        {
            result.add(new ArrayList<>());
        }
        result.get(size).add(root.val);
        helper(root.left, size+1);
        helper(root.right,size+1);
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

//Time Complexity : O(n) where n is the number of nodes in the tree
//Space Complexity : O(n) where n is the nodes in the recursive stack
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :