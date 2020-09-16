import java.util.*;

//Recursion
//TC: O(N) - N - no of nodes in tree. We traverse through each node.
//SC: O(N) - recursive stack will contain at most N nodes.

//Iterative
//TC: O(N)
//SC: O(N) Queue will contain N nodes.

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){};
    public TreeNode(int val){
        this.val = val;
    }
}
public class LevelOrderTraversalR{
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        helper(root, 0);
        return result;
    }

    private static void helper(TreeNode node, int level){
        if(node == null) return;

        if(result.size() == level)
            result.add(new ArrayList<>());

        result.get(level).add(node.val);
        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }

    public static List<List<Integer>> levelOrderTraversalIterative(TreeNode root){

        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while( !q.isEmpty() ){
            
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            
            for( int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                list.add(temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);      
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(28);

        List<List<Integer>> result = levelOrderTraversal(root);
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }

        List<List<Integer>> result2 = levelOrderTraversalIterative(root);
        for(int i = 0; i < result2.size(); i++){
            System.out.println(result2.get(i));
        }
    }
    
}