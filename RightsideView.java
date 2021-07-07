package com.ds.rani.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */

//Approach: Using level order traversal, for every level just add the last element in result
//Time Complexity:o(n) where n is number of nodes in tree
//space Complexity:o(w) where w is maximum width of the tree

public class RightsideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        //If tree is null
        if (root == null)
            return result;

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add( root );
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.remove();
                //always adding last element at each level. so last element at every level will be the
                // rightmost element for that level
                if (i == size - 1)
                    result.add( curr.val );
                if (curr.left != null)
                    que.add( curr.left );
                if (curr.right != null)
                    que.add( curr.right );
            }

        }
        return result;

    }
}


