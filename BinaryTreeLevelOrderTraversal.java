class Solution {

     //  Time Complexity: O(n)
     //  Space Complexity:  O(n)
     // BFS Approach

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);
        while(queue.size() != 0){
            int len = queue.size();
            List<Integer> l = new ArrayList<>();

            for(int i = 0; i < len; i++){
                TreeNode node = queue.remove();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                l.add(node.val);
            }
            list.add(l);
        }
        return list;
    }


     //  Time Complexity: O(n)
     //  Space Complexity:  O(h)
     // DFS Approach

     List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int height){
        if(root == null) return;
        if(result.size() == height){
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);
        helper(root.left, height + 1);
        helper(root.right, height + 1);   
    }
 
}