/**
 * Time complexity : O(n)  where n = nodes. As we will be visiting each node only once;
 * Space complexity : O(n) As we will be storing all the nodes that needs to be returned level wise
 */

//In the first program, we are taking dfs approach, whenever we reach a level that has not been visited,
// We add another arraylist and add elements in it

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    List<List<Integer>> list;
    public List<List<Integer>> levelOrder(TreeNode root) {


        list = new ArrayList<>();
        helper(root,0);
        return list;
    }
    public void helper(TreeNode root,int level)
    {
        if(root == null) return;
        if(level == list.size())
        {
            ArrayList<Integer> l = new ArrayList<Integer>();
            list.add(l);
        }
        list.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }



    //Here we will be taking bfs approach. We will be maintaing a queue and adding all elements of next level in the queue

    List<List<Integer>> listt;
    public List<List<Integer>> levelOrder2(TreeNode root) {
        list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            List<Integer> arr = new ArrayList<>();
            int size = q.size();
            for(int i = 0 ; i < size; i ++)
            {
                TreeNode curr = q.poll();
                arr.add(curr.val);
                if(curr.left!= null) q.add(curr.left);
                if(curr.right!= null) q.add(curr.right);
            }
            listt.add(arr);
        }
        return listt;
    }

}

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