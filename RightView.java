//time complexity:O(number of nodes)
//space complexity:O(number of leaf nodes)
/*Approach
-using bfs to traverse the tree level by level and the last element at every level will be the
element seen from the right side 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    public static class TreeNode {
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
       
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
                TreeNode curr = q.poll();
                if(i == size-1)result.add(curr.val);
                if(curr.left != null){q.add(curr.left);}
                if(curr.right != null){q.add(curr.right);}

            }
        }
        return result;
    }
public static void main(String args[]) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(4);

    root.left.left= new TreeNode(2);
    root.left.right = new TreeNode(1);

    RightView obj = new RightView();
    System.out.println(obj.rightSideView(root));
    
}

}