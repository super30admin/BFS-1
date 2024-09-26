// Time complexity: o(n);
// space complexity: o(n);
// idea: 
//  a) push the root value initially to sublist (which inturn gets pushed to main list).
//  b) check for left and right nodes. If nodes are available, push the node values to sublist, 
//  c) maintain a queue to check for left and right nodes at each level and push it. 
//  d)repeat the cycle till the end of the tree is reached.

// Did it run on leetcode: yes

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
        List<List<Integer>> mainList = new ArrayList<List<Integer>>();
        List<Integer> innerList = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> subQueue = new LinkedList<TreeNode>();
        if(root==null) return mainList;
        
        innerList.add(root.val);
        queue.add(root);
        mainList.add(innerList);
        innerList = new ArrayList<Integer>();
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left!=null) {
                subQueue.add(node.left);
                innerList.add(node.left.val);
            }
             if(node.right!=null) {
                subQueue.add(node.right);
                innerList.add(node.right.val);
            }
            if(queue.isEmpty()) {
                if(innerList.size()>0) {
                mainList.add(innerList);
                queue = subQueue;
                innerList = new ArrayList<Integer>();
                subQueue = new LinkedList<TreeNode>();
                }
            }
        }
        
        return mainList;
    }
}