/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
We will use Queue to store tree nodes .We push root node to queue.Pop the root node and add its left and right node
to queue.Keeping processing the nodes until queue is empty 
*/


import java.util.*;

import javax.swing.tree.TreeNode;
public class BinaryTreeRightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        if(root == null) return output;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int index = 1;  index <= size; index++){
                TreeNode node = queue.remove();

                if(index  == size){
                    output.add(node.val);
                }

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return output;
    }
}