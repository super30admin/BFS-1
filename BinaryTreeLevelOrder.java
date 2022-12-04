//https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/853928993/
/*
BFS Approach
Binary Tree Level Order Traversal - To traverse in BT we require something to store the elements as if you begin from root node how
will you traverse to the child nodes. We use queue for storage. We check for the root node insert it into the queue then we poll the root
element we check if they had any child nodes. If present then add them to queue and check for their children and print them.
Issue - everything will be printed in single list and requirement is to print it into different lists. So we maintain a size variable.
* Further we check 2 conditions if left child is present then we add that child to queue and if right child is present we add it to the queue
once the queue is empty we return the result list

Time Complexity - O(n) - where n = number of nodes
Space Complexity - O(n/2) = O(n) - where n/2 = the maximum width of the tree.

DFS Approach - Similar to above only the way to traverse is different. We check the root node and
recursively implement dfs method. In DFS method we add a new list once we reach a new level.
Time Complexity - O(n) - where n = number of nodes
Space Complexity - O(h) - recursive stack space.

* */

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
  }

public class BinaryTreeLevelOrder {/*
    public List<List<Integer>> levelOrder(TreeNode root) {

     //base case
     if(root == null )return new ArrayList<>();

     //logic
     List<List<Integer>> result = new ArrayList<>();
     Queue<TreeNode> q = new LinkedList<>();
     q.add(root);
     while(!q.isEmpty()){
         int size = q.size();
         List<Integer> list = new ArrayList<>();
         for (int i = 0; i < size; i++) {
             TreeNode curr = q.poll();
             list.add(curr.val);
             if(curr.left!=null) q.add(curr.left);
             if(curr.right!=null)q.add(curr.right);
         }
         result.add(list);
     }
    return result;
     }
*/
List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        //base case
        if(root==null) return new ArrayList<>();
        result= new ArrayList<>();
        dfs(root,0);
        return result;
    }
private void dfs(TreeNode root, int level){
if(root==null) return;
if (level ==result.size()) result.add(new ArrayList<>());
result.get(level).add(root.val);
dfs(root.left,level+1);
dfs(root.right,level+1);

}
}
