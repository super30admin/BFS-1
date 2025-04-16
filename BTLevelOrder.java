
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
It uses a recursive approach where each recursive call passes along the current level information.
Whenever a new level is encountered, a new list is added to the result to hold the values for that level.
 Node values are added to the appropriate list based on their level, and the process continues for
 both left and right children. The solution runs in O(n) time and uses O(h) space,
where n is the number of nodes and h is the height of the tree due to recursion stack space.
* */
import java.util.ArrayList;
import java.util.List;

class BTLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();

        levelOrder(root,0,result);
        return result;
    }

    private void levelOrder(TreeNode root,int level,List<List<Integer>> result)
    {
        if(root==null)
            return;

        if(result.size()==level)
        {
            result.add(new ArrayList<>());

        }

        //will work in any sequence for below
        result.get(level).add(root.val);
        levelOrder(root.left,level + 1,result);
        levelOrder(root.right,level + 1,result);

    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}