//TC : O(n)
//SC: O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> res = new ArrayList<>();
            while(size > 0) {
                TreeNode node = queue.remove();
                if(node != null) {
                    res.add(node.val);
                    if(node.left != null) 
                        queue.add(node.left);
                    if(node.right != null) 
                        queue.add(node.right);
                }
                size--;
            }
            result.add(res);
        }
        return result;
    }
}