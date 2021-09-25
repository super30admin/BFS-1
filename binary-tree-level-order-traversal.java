//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        //Initially add root to the queue
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            //start at the current level
            result.add(new ArrayList<>());
            
            //iterate through the size of the queue
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                //add the node at the level
                result.get(level).add(node.val);
                
                //add the child nodes of the current level in the queue
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        return result;
    }
}