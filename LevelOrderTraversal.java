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

 /*
time complexity : O(N) where N is the number of nodes;
space complexity: O(N)
approach: BFS implemented so traversed for each level where we add children of each node
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return result;

        queue.add(root);

        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> levelList = new ArrayList<>();

            while(level > 0){

                TreeNode curr = queue.poll();

                levelList.add(curr.val);

                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    queue.add(curr.right);
                }

                level--;

            }

            result.add(levelList);

        }

        return result;
    }
}
