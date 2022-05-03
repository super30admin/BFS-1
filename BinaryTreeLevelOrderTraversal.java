import java.lang.System.Logger.Level;
import java.util.*;
public class BinaryTreeLevelOrderTraversal{

    public static List<List<Integer>> result;

    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        result = new ArrayList<>();

        if(root == null)
        {
            return result;
        }

        dfs(root,0);

        return result;
    }


    public static void dfs(TreeNode root, int level)
    {
        if(root == null)
        {
            return;
        }

        if(level == result.size())
        {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }


    public static void main(String args[])
    {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);

        TreeNode twentyLeft = new TreeNode(15);
        TreeNode twentyRight = new TreeNode(7);

        root.left=rootLeft;
        root.right=rootRight;

        rootRight.left=twentyLeft;
        rootRight.right=twentyRight;

        List<List<Integer>> ans = levelOrder(root);

        for(List<Integer> li : ans)
        {
            System.out.println(li);
        }
    }
}