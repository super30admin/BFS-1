/*
* Approach:
*  1. Apply BFS starting from the root.
* 
*  2. Process the root by pushing all its children into queue.
        As we have to add the curr level(left to right) the result array,
        we can maintain a level array.
* 
*  3. Elements in different levels can be identified by taking size,
         before processing the node.
        Once a level is processed, all the level elements to result.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(N)
    N = nodes
* 
* Space Complexity: O(W) ===> O(N)
    W = width of tree in a queue or level
    max width = N/2
* 
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> arr = new ArrayList<>();

            int size = queue.size();

            for (int index = 0; index < size; index++) {
                TreeNode curr = queue.poll();

                arr.add(curr.val);

                if (curr.left != null)
                    queue.add(curr.left);

                if (curr.right != null)
                    queue.add(curr.right);
            }

            result.add(arr);
        }

        return result;
    }
}
