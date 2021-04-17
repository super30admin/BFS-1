//BFS - Queue
//Time - O(n) - N - number of nodes in the tree
//Space - O(N) - Queue size - number of nodes in the tree

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
  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();
    if(root == null){
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){

      int size = queue.size();
      System.out.println("size: "+size);
      List<Integer> list = new ArrayList<>();

      for(int i=0; i<size; i++){

        TreeNode node = queue.poll();
        list.add(node.val);

        if(node.left != null){
          queue.add(node.left);
        }
        if(node.right != null){
          queue.add(node.right);
        }

      }
      result.add(list);
    }

    return result;
  }
}


//Recursion
//Time - O(n) - N - number of nodes in the tree
//Space - O(N) - Implicit recursion call stack stack - number of nodes in the tree
class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();
    if(root == null){
      return result;
    }

    helper(root, result, 0);
    return result;
  }

  public void helper(TreeNode node, List<List<Integer>> result, int level){

    if(node == null){ return; }
    //
    if(level == result.size()){
      result.add(new ArrayList<>());
    }

    result.get(level).add(node.val);

    helper(node.left, result, level+1);
    helper(node.right, result, level+1);

  }
}