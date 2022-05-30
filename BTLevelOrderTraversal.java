//Time: O(n)
//Space: O(n)
public class BTLevelOrderTraversal {
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //null
        if (root == null) return result;
        Queue q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = (TreeNode) q.poll();
                temp.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);

            }
            result.add(temp);

        }
        return result;
    }
}
