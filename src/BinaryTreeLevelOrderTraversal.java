import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.util.customlist.TreeNode;
//for BFS
// Time Complexity : O(n)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

//for DFS
//Time Complexity : O(n) 
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

public class BinaryTreeLevelOrderTraversal {
	//BFS
    public static List<List<Integer>> levelOrderUsingBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);//push   3
        
        while(!q.isEmpty()){
            int size = q.size();  //1 2 2
            List<Integer> lt = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode curr = q.poll();//pop 9 20
                lt.add(curr.val);//9 20
                if(curr.left != null)
                    q.add(curr.left); //15
                if(curr.right != null)
                    q.add(curr.right); //7
            }
            result.add(lt);
        }
        return result;
    }
    
    //DFS
    static List<List<Integer>> result;
    public static List<List<Integer>> levelOrderUsingDFS(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    
    private static void dfs(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20));
		TreeNode rootL = new TreeNode(9,null,null);
		TreeNode rootR = new TreeNode(20, new TreeNode(15), new TreeNode(7));
		root.left = rootL;
		root.right = rootR;
		
		System.out.println(BinaryTreeLevelOrderTraversal.levelOrderUsingBFS(root));
		System.out.println(BinaryTreeLevelOrderTraversal.levelOrderUsingDFS(root));
		
	}
    
}
