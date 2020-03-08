# Time complexity:O(n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int countNodes = queue.size();
            List<Integer> currentlevel = new LinkedList<>();

            for(int i = 0; i < countNodes; i++){
                TreeNode current = queue.poll();
                currentlevel.add(current.val);
            if(current.left != null){
            queue.add(current.left);
            }

            if(current.right != null){
                queue.add(current.right);
            }


            }
            result.add(currentlevel);

        }
        return result;
    }
}