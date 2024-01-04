// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : BFS

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> temp = new ArrayList();
            TreeNode node;

            for(int i = 0; i < size; i++)
            {
                node = queue.poll();
                temp.add(node.val);

                if(node.left != null) queue.add(node.left);

                if(node.right != null) queue.add(node.right);
            }

            result.add(new ArrayList(temp));
            
        }

        return result;
    }
}