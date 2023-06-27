import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BTLevelOrderTraversalIterative {

    //ITERATIVE - QUEUE - BFS


        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> result = new ArrayList<>();

            // null case
            if(root == null) return result;

            Queue<TreeNode> queNodes = new LinkedList<>(); // O(n/2) = n/2 breadth at the bottom

            queNodes.add(root);

            //
            while(!queNodes.isEmpty()) {

                int sizeQ = queNodes.size();
                List<Integer> level = new LinkedList<>();

                for(int i = 0; i < sizeQ; i++) { //O(n)

                    TreeNode curr = queNodes.poll();
                    // add popped out node to a level
                    level.add(curr.val);


                    // add popped node's children to queue
                    if(curr.left != null) queNodes.add(curr.left);
                    if(curr.right != null) queNodes.add(curr.right);
                }
                result.add(level);
            }
            return result;
        }

}
/* Time Complexity = O(n) - running over all nodes
Space Complexity = O(n) = maximum n/2 nodes(leaves) go into the queue at the bottom level
= breadth of the tree at the bottom
*/