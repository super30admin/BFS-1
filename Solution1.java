// Recursive Solution
// Time Complexity -> O(n) where n is number of nodes in the Tree
// Space Complexity -> O(n)
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
class Solution1 {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode node, int level) {
        //base case
        if( node == null ) {
            return;
        }
        if( result.size() == level ) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        helper(node.left, level+1);
        helper(node.right, level+1);
    }
}


// Iterative Solution
// Time Complexity -> O(n) where n is number of nodes in the Tree
// Space Complexity -> O(n)
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         if( root == null ) {
//             return result;
//         }
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while( !q.isEmpty() ) {
//             int size = q.size();
//             List<Integer> list = new ArrayList<Integer>();
//             for(int i = 0; i < size; i++) {
//                 TreeNode temp = q.poll();
//                 list.add(temp.val);
//                 if( temp.left != null ) {
//                     q.add(temp.left);
//                 }
//                 if( temp.right != null ) {
//                     q.add(temp.right);
//                 }
//             }
//             result.add(list);
//         }
//         return result;
//     }
// }