
/*
Time: O(N) where N is the number of nodes in the Tree
Space: O(N)
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
class Problem1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
 
         List<List<Integer>> result = new ArrayList<>();
 
         if (root == null)
             return result;
 
         Queue<TreeNode> q = new LinkedList<>(); // Queue as a LL
 
         q.add(root); // always add the root first to the q
 
         while (!q.isEmpty()) // process all elems until q is not empty
         {
 
             int levelNum = q.size();
             List<Integer> currentLevel = new ArrayList<>(); // create a new list for every level
 
             for (int i = 0; i < levelNum; i++) // loop through all the elements in that level
             {
                 TreeNode current = q.remove(); // remove the elem from queue and add it to list
                 currentLevel.add(current.val);
 
                 if (current.left != null) // meanwhile, check for its left,right and add to q.
                     q.add(current.left);
 
                 if (current.right != null)
                     q.add(current.right);
             }
 
             result.add(currentLevel);
 
         }
 
         return result;
 
     }
 
 }