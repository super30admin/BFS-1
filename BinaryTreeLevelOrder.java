//Average Time Complexity O(n)
//Space Complexity O(n)
//Leetcode tested

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//Time and Space O(n)
public class BinaryTreeLevelOrder {
    //iterative
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                currentList.add(current.val);
                if(current.left!=null)queue.add(current.left);
                if(current.right!=null)queue.add(current.right);
            }
            result.add(currentList);
        }
        return result;
    }

    //recursive
    public List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        traverse(root,0);
        return result;
    }
    public void traverse(TreeNode root,int level){
        if(root == null) return;

        if(level == result.size()){
            ArrayList<Integer> list =new ArrayList<>();
            list.add(root.val);
            result.add(list);
        }else{
            result.get(level).add(root.val);
        }
        traverse(root.left,level+1);
        traverse(root.right,level+1);
    }
}
