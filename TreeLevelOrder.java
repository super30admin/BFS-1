import java.util.*;
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
public class TreeLevelOrder {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {

        result = new ArrayList<>();

        dfs(root,0);

        return result;

    }

    public void dfs(TreeNode root, int level){

        if(root==null) return;

        if(level==result.size())
        {
            List<Integer> temp=new ArrayList<Integer>();
            result.add(temp);
        }

        result.get(level).add(root.val);

        dfs(root.left,level+1);

        dfs(root.right,level+1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeLevelOrder treeLevelOrder = new TreeLevelOrder();
        List<List<Integer>> result = treeLevelOrder.levelOrder(root);
        for(List<Integer> list:result)
        {
            System.out.println(list);
        }
    }
}
