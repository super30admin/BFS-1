import java.util.List;
import java.util.ArrayList;

public class BTLevelOrderTraversalRecursive {

    // RECURSION - BFS
        List<List<Integer>> result;
        public List<List<Integer>> levelOrder(TreeNode root) {

            result = new ArrayList<>();

            recursiveBfs(root, 0);
            return result;
        }

        public void recursiveBfs(TreeNode root, int level) {

            //base case
            if(root == null) return;

            //logic - preorder only
            //let the level lists be created first before adding roots at levels
            if(result.size() == level) {
                // if level is same as result size, that level list is not present yet in result
                result.add(new ArrayList<>());
            }

            // putting in root can be done in any order (pre, post, in)
            // add root value to a corresponding level list in result
            result.get(level).add(root.val);

            // go to root's children
            recursiveBfs(root.left, level+1);
            //st.pop()
            recursiveBfs(root.right, level+1);

        }
}

/* Time Complexity = O(n) - ended up traversing all nodes
Space Complexity = O(H) = worst case O(n) when skewed tree
= recursive stack holds maximum of number of elements = height of the tree
*/