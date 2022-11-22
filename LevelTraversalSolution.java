//Time complexity: O(n)
//Space complexity: O(n)

class LevelTraversalSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //Base case
        if(root == null) {
            return result;
        }
        //Queue data structure for BSF
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            //At each level creating an new list.
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i += 1) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}