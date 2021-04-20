/*
Thought Process: 
Level Order travesal is another name for BFS. So solving this using basic concepts of BFS.

TC -> O(N) where N is the total number of nodes in the tree
SC -> O(K) where K is count of leaf nodes (Maximum size of the queue)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> listRes = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode polled = q.poll();
                listRes.add(polled.val);
                if(polled.left != null) q.add(polled.left);
                if(polled.right != null) q.add(polled.right);
            }
            res.add(listRes);
        }
        return res;
    }
}