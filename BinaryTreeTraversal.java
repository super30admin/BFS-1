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
// //BFS using Queue. TC=O(n), SC=O(n/2)=O(n)
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         if(root==null) return result;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             List<Integer> li = new ArrayList<>();
//             for(int i=0; i<size; i++){
//                 TreeNode curr = q.poll();
//                 li.add(curr.val);
//                 if(curr.left!=null){
//                     q.add(curr.left);
//                 }
//                 if(curr.right!=null){
//                     q.add(curr.right);
//                 }
//             }
//             result.add(li);
//         }
//         return result;
//     }
// }

//DFS. TC=O(n), SC=O(h)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root,0,result);
        return result;
    }
    private void helper (TreeNode root, int level, List<List<Integer>> result){
        //base
        if (root==null) return;
        //logic
        if(level==result.size()){
            result.add(new ArrayList<>());
        }
        List<Integer> li = result.get(level);
        li.add(root.val);
        //result.set(level, li);
        level += 1;
        helper(root.left, level, result);
        helper(root.right, level, result);
    }
}