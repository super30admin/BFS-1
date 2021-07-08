class LevelOrder {

    //Time Complexity: O(V + E)
    //Space Complexity; 

    public List<List<Integer>> levelOrder(TreeNode root) {

        //O(n) time as we process each node onece
        //O(n) space but it is actually the max number of nodes in the queue at once, which would be at the bottom level of the tree
        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {

            levels.add(new ArrayList<Integer>());
            int levelSize = queue.size();

            for (int i=0; i<levelSize; i++) {

                TreeNode node = queue.remove();

                levels.get(level).add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }

            level++;

        }

        return levels;

    }

}