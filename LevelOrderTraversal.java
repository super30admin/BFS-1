import java.util.ArrayList;
import java.util.List;

/*
Time complexity: O(H)- height of the tree
Space Complexity: O(N)
Run on leetcode: yes
Any difficulties: No

Approach:
1. Recursively add values at root and increase the level
 */
public class LevelOrderTraversal {
    public static class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode(){
        }
        TreeNode(int val ){
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<List<Integer>> levels;
    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        levels = new ArrayList<>();
        if(root == null){
            return levels;
        }
        levelOrderRecursion(root, 0);
        return levels;
    }

    public static void levelOrderRecursion(TreeNode root, int level){
        if(levels.size() == level){
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(root.val);

        if(root.left!= null){
            levelOrderRecursion(root.left, level+1);
        }

        if(root.right!= null){
            levelOrderRecursion(root.right, level+1);
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Level order traversal: "+ levelOrderTraversal(root));
    }
}
