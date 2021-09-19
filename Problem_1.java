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

// bfs
// Time Complexity : O(n)
// Space Complexity :O(h) h is hight of the tree
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
//
// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if( root == null ) return result;
        bfs(root,0);
        return result;
    }
    private void bfs(TreeNode root, int level){
        //base
        if( root == null ) return;
        //logic
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        bfs(root.left, level+1);
        // st.pop return  when null
        bfs(root.right, level+1);
        // st.pop
    }
}

// dfs

// // Time Complexity : O(n)
// // Space Complexity :O(n/2)
// // Did this code successfully run on Leetcode : Yes
// // Three line explanation of solution in plain english
// // get he treenode q and put the root node in it, traver the q till it lenght, then add the value to new list, and check if left and right node are present or not? if yes then add it to the queue
// // Your code here along with comments explaining your approach
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         if( root == null ) return result;
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             List<Integer> newList = new ArrayList<>();
//             for( int i = 0; i < size; i++ ){
//                 TreeNode topNode = q.poll();
//                 newList.add(topNode.val);
//                 if(topNode.left != null){
//                     q.add(topNode.left);
//                 }
//                 if(topNode.right != null){
//                     q.add(topNode.right);
//                 }
//             }
//             result.add(newList);
//         }
//         return result;
//     }
// }

// // my old way
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         Queue<TreeNode> subQ = new LinkedList<>();
//         List<Integer> subResult = new ArrayList<>();
//         if( root == null ) return result;
//         q.add(root);
//         subResult.add(root.val);
//         result.add(new ArrayList<>(subResult));
//         subResult.clear();
//         while(!q.isEmpty()){
//             root = q.remove();
//             if( root.left != null){
//                 subResult.add(root.left.val);
//                 subQ.add(root.left);
//             }
//             if( root.right != null){
//                 subResult.add(root.right.val);
//                 subQ.add(root.right);
//             }
//             if(q.size() == 0 && subResult.size() != 0){
//                 result.add(new ArrayList<>(subResult));
//                 q.addAll(subQ);
//                 subQ.clear();
//                 subResult.clear();
//             }
//         }
//         return result;
//     }
// }