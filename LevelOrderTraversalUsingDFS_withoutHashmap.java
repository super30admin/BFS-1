// Time Complexity : O(n) number of nodes in tree
// Space Complexity : O(n/2) -> O(n) in worst case q will have all the nodes at last level of tree and a tree no of nodes on last level =n/2
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// using DFS , take a result arraylist and chcek its size if size == level we are at it means this starting of this level nodes so create a new list and add that to result list
   // otherwise get the list stored at index(== level) and add new root val in that and then add it back to the result list


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
          List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
      
        dfs(root,0);
        return resultList;
    }
    
    private void dfs(TreeNode root, int level)
    {
        if(root == null) return;
        List<Integer> list = new ArrayList<>();
        if(resultList.size() == level)
        {
            list = new ArrayList<>();
            list.add(root.val);
            resultList.add(list);
        }
        else
        {
            list = resultList.get(level);
            list.add(root.val);
        }
        dfs(root.left,level+1);
         dfs(root.right,level+1);
    }
}