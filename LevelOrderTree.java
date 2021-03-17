//Time complexity: O(n)
//Space complexity: O(1)
//Executed on leetcode.

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
    List<List<Integer>> output = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return output;
        List<TreeNode> rootList = new ArrayList<>();        //Traversing through each level.
        rootList.add(root);     //Subtrees at each level are stored to a list forwarded to the next level.
        BFS(rootList);
                                //When no subtrees are available returing. 
        return output;
    }
    
    void BFS(List<TreeNode> rootList)
    {
        if(rootList.size()==0)
            return;
        List<TreeNode> tempList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(TreeNode root:rootList)
        {
            if(root.left!=null)
                tempList.add(root.left);
            if(root.right!=null)
                tempList.add(root.right);
            list.add(root.val);
        }
        output.add(list);
        BFS(tempList);
    }
}