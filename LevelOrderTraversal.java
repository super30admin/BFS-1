import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LevelOrderTraversal {

    // TC: O(n)
    // SC: O(n) -> The upper bound for n would be 2^h - 1, number of nodes at a given level
    // n is the number of nodes in a tree

    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> li = new ArrayList<>();
            for(int i=0; i < size; i++) {
                TreeNode temp = queue.poll();
                li.add(temp.val);
                if(temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(li);
        }
        return result;
    }

    // This will use DFS traversal to print the elements in BFS way
    public List<List<Integer>> levelOrderUsingDFS(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;

        dfs(root,0);
        return result;
    }

    // Strategy-
    // For each level, check the number of lists in the result
    // If it matches that means we don't have a list to hold the current level. Level starts at 0
    // So, for each level create a new list if it doesn't exist else point to existing one and append the current level element to that list
    private void dfs(TreeNode root, int level) {
        // Base condition
        if(root == null) return;

        if(level == result.size()){
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
