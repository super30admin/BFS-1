class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currResult = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                currResult.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            result.add(currResult);
        }
        return result;
    }
}

Time Complexity: O(n) where n is the number of nodes
Space Complexity: O(n) where n is the maximum queue size 