package s30.BFS;

import s30.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// Time Complexity O(n); Iterating through all the nodes of tree.
// Space Complexity O(n/2) at max we'll have all leaves in the queue.
public class levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList();

        if(root == null) return res;

        Queue<TreeNode> levelQueue = new LinkedList();

        levelQueue.add(root);


        while(!levelQueue.isEmpty()){


            // Queue<TreeNode> nextLevel = new LinkedList();
            List<Integer> currNodes = new ArrayList();

            int size = levelQueue.size();

            while(size > 0){

                TreeNode node = levelQueue.poll();
                currNodes.add(node.val);

                if(node.left != null) levelQueue.add(node.left);
                if(node.right != null) levelQueue.add(node.right);
                size--;
            }

            res.add(currNodes);

        }


        return res;

    }
    public static void main(String[] args) {

    }
}
