//Time complexity: O(n)
//Space complexity: O(n)
//Approach :
//while traversing the list of lists-prerequisites,
//create a hashmap with keys as a prereq course and array of dependencies as value
//create an array with index numbers denoting the course and value denoting number of courses it depends on
//go through the array and push indexes in queues that have 0 dependencies
//or every course in queue, get all the dependencies from the hashmap and reduce their value by 1 in the array, if the value becomes 0, add the course to the queue
//if all the values in array are 0 , return True else return false

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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        //dfs(root, 0);
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);

         while(!queue.isEmpty()) {
             int size = queue.size();
             //create a new list at each level
             List<Integer> list = new ArrayList<>();

             for(int i=0; i<size; i++){
                 TreeNode curr = queue.poll();
                 //add the current value to the list
                 list.add(curr.val);

                 //if the left child is not null, add it to the queue
                 if(curr.left != null){
                     queue.add(curr.left);
                 }

                 //if the right child is not null, add it to the queue
                 if(curr.right != null){
                     queue.add(curr.right);
                 }
             }
             //add the list to the result at each level
             result.add(list);
         }
        return result;
    }

//    void dfs(TreeNode node, int level) {
//
//        if(node == null) return;
//
//        if(level == result.size()){
//            result.add(new ArrayList<>());
//        }
//        result.get(level).add(node.val);
//        dfs(node.left, level+1);
//        dfs(node.right, level+1);
//    }
}