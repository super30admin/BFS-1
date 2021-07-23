// Time Complexity : O(N) since each node is processed exactly once
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode tempNode = queue.poll();
                temp.add(tempNode.val);
                if(tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if(tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}