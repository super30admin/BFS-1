//approach-here i am using a recursive approach, while traversing the tree in any order, i am passing a local variable h(to represent the depth at each level), at each level, I have a list for that level and each index represents that level. at each level we create or get that list if it exists and add the root level while recursively traversing the tree. This way i am ensuring to add all nodes on the same level to the same list in the level wise order.
//Time complexity would be O(n) as we are visiting each node once
//space complexity would be O(h) as at most we would have h(height) recusive calls in my recursive stack. Here i am talking about auxillary space i.e excluding the space consumed by the output
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
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int h) {
        if (root == null) return;

        if(result.size() <= h)result.add(new ArrayList<>());
        
        helper(root.left, h + 1);
        result.get(h).add(root.val);
        helper(root.right, h + 1);
    }
}
