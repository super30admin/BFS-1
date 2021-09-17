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
        
        List<List<Integer>> result = new ArrayList<> ();
        if (null == root) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add (root);
        
        while (!q.isEmpty()) {
            
            int size = q.size ();
            List<Integer> temp = new ArrayList<>();
            
            for (int i=0; i<size; i++){
                TreeNode curr = q.poll();
                System.out.println("Q Polled Current Node: "+curr.val+ ",curr size: "+size+" ,qsize :"+q.size());
                temp.add (curr.val);
                
                if(null != curr.left) q.add(curr.left);
                if(null != curr.right) q.add(curr.right);
            }
            result.add(temp);
        }
        
        return result;
    }
}
