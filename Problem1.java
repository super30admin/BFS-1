//Binary Tree Inorder Level Traversal
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
/*
For inorder, we do BFS on the tree. At each level we look for its left and right side
We save nodes in queue at each level and take the size of queue and traverse its right and left
we traverse till the queue is not empty

*/
import java.util.*;
class Problem1{
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Problem1 p = new Problem1();
        System.out.println(p.levelOrder(root));
        

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        //tc - O(n)
        //sc - O(n)
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
           // System.out.println(size);
            List<Integer> ls = new ArrayList<>();
            while(size >0){
                
                TreeNode curr = q.remove();
                ls.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                size--;
                
            }
            res.add(ls);
        }
        return res;
    }
}