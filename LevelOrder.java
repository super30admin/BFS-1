package com.ds.rani.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */

//Approach: For level order traversal queue is the best data structure, visit root, add it in result and add its
//children in queue.remove one node from queue and apply the same process till we doesnt finish all the nodes

//Time Complexity:o(n) where n is number of nodes in tree
//space Complexity:o(w) where w is maximum width of the tree
public class LevelOrder {


    public List<List<Integer>> levelOrder(TreeNode root) {

        //Edge case,when tree is null
        if (root == null)
            return new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        queue.add( root );

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                //add current node in result
                TreeNode current = queue.remove();
                level.add( current.val );

                //add current nodes children in queue
                if (current.left != null)
                    queue.add( current.left );

                if (current.right != null)
                    queue.add( current.right );
            }
            result.add( level );


        }
        return result;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
