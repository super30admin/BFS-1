// Time Complexity - O(n) where n is the number of nodes
// Space Complexity - O(n) where n is the number of nodes
// This solution worked on LeetCode

// We are implementing the Binary Tree Level Order Traversal using BFS where the queue is used to maintain the level order. queue size will be used to keep track of the width of the level. The root will be first added to the queue. The queue size will be calculated. The queue will be   

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;     // If root is null return empty list of list
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); 
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> levelList = new ArrayList<>(); 
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                levelList.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(levelList);
        }
        return res;
    }
}
