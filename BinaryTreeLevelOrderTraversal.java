package BFS1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*S30 Big N Problem #56 {Easy} - https://www.youtube.com/watch?v=4daVf8a9JmY
    You are given a binary tree . you have to return the level order traversal of it(i.e. from left to right, level by level). 



            For example:
            Given binary tree [30,9,20,null,null,5,7],
               30
               / \
              9  20
                /  \
               5   7

            return its level order traversal as:
            [ [30],
              [9,20],
              [5,7]]
Source Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
-------------------------------------------------------------------------------------------------------
Time complexity :BFS - O(N) - traversing all nodes
                 DFS - O(N) - traversing all nodes
space complexity: BFS - O(N/2) = O(N) number of leaf nodes = N/2
                  DFS - O(H)  height of the tree
Did this code run successfully in leetcode : yes
problems faces : no*/

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> nodeLevelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                nodeLevelList.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

            }
            result.add(nodeLevelList);
        }

        return result;

    }
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> levelOrderWithDFS(TreeNode root) {

        if (root == null)
            return result;

        dfs(root,0);
        return result;

    }

    private void dfs(TreeNode root, int level) {
       
        //base
        if(root == null) return;
        
        //logic
        if(level == result.size())
        {
            List<Integer>  list = new ArrayList<>();
            result.add(list);
        }
        result.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        
    }

}
