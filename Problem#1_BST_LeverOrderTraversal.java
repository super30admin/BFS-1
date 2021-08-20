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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //Iterative level order traversal        
        //Base case
        if(root==null){
            return new ArrayList();
        }
        List<List<Integer>> levels = new ArrayList<>();
        //Cannot use stack here, we need queue!
        // Stack<TreeNode> s = new Stack();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> li = new ArrayList<>();
            //Need to keep taking nodes out of queue, until all on the same level are popped.
            for(int i = 0; i<size ; i++){
                TreeNode curr = q.poll();
                 li.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }   
            }
           levels.add(li);
        }
        return levels;
        
    }
}