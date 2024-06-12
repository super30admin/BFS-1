//Time Complexity: O(n)
//Space Complexity: O(n)
//Solved on Leetcode: Yes

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        

        List<List<Integer>> finalList = new ArrayList<>();
        if (root == null) return finalList;
        
        Queue<TreeNode> levelQueue = new LinkedList<>();
        
        levelQueue.offer(root);
        while ( !levelQueue.isEmpty() ) {
            int size = levelQueue.size();
            List<Integer> levelList = new ArrayList<> ();
            for (int i=0; i<size; i++) {
                TreeNode node = levelQueue.poll();
                levelList.add(node.val);
                if(node.left != null) {
                    levelQueue.add(node.left);
                }
                
                if(node.right != null) {
                    levelQueue.add(node.right);
                }
            }
            
            finalList.add(levelList);
        }
        return finalList;
     }
}