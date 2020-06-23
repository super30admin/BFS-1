/**
 * Time Complexity : O(n) We will be visiting each node in worst case scenario
 * Space Complexity : O(h) height of the tree (One element for each level)
 * Here we will be using preorder traversal will right side before left side;
 * 
 */

import java.util.*;
public class RightSideView {
    List<Integer> list;
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        helper(root,0);

        return list;
    }
    public void helper(TreeNode root, int level)
    {
        if(root== null) return;

        if(list.size() == level)
        {
            list.add(root.val);
        }

        helper(root.right,level+1);
        helper(root.left,level+1);
    }
}