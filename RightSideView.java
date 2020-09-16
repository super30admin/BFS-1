import java.util.*;

//TC: O(N) N - no of trees
//SC: O(N)

//Recursive Logic
//Keep the level of nodes, at each level just add the right most node to result list.
//If the size of list is equal to level, right most of that level is added to list, and we need not add other nodes in that level.

public class RightSideView {
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> rightView(TreeNode root){
        
        if(root == null) return res;
        helper(root, 0);
        return res;

    }

    private static void helper(TreeNode node, int level){

        if(node == null) return;

        if(res.size() == level){
            res.add(node.val);
        }
        helper(node.right, level + 1);
        helper(node.left, level + 1);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(28);

        List<Integer> result = rightView(root);
        //for(int i = 0; i < result.size(); i++){
            System.out.println(result);
        //}
    }
}
