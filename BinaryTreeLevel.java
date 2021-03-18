import java.util.*;

//Similar to normal BFS like adding the items in a queue. and traverse children.
//Since we need the list. Get the size of the queue. which the current level size.
//Iterate till the size and add the items in the current list.

//TC: O(N) - Visiting all the nodes.
//SC: O(N) - Since we used queue for auxilary purpose.
public class BinaryTreeLevel {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(levelList);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode().getSample();
        BinaryTreeLevel binaryTreeLevel = new BinaryTreeLevel();
        List<List<Integer>> result = binaryTreeLevel.levelOrder(treeNode);
        System.out.println("The Result is" + result);
    }
}