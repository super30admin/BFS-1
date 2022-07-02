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
class BFSSolution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> resultList = new ArrayList<>();
        
        if (root==null) 
            return resultList;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        
        while (!q.isEmpty()) {
            int size = q.size();
           
            List<Integer> li = new ArrayList<>();
            for (int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                li.add(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right); 
            }
            
            resultList.add(li);
            System.out.println("List resultList=== "+resultList);
        }
        
      return resultList;  
    }
}