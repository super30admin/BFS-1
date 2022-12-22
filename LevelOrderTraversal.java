import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

//Time Complexity : O(n) 
//Space Complexity :O(n)// in worst case n/2 would be in the queue in case of bfs approach
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                }
            result.add(level);
        }
        
        return result;
    }
	
	//Time Complexity : O(n) 
	//Space Complexity :O(h)// h size internal stack for recursion 
	//Did this code successfully run on Leetcode :Yes
	//Any problem you faced while coding this :

	
	 List<List<Integer>> result = new ArrayList<>();
	    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
	        helper(root,0);
	        return result;
	    }
	  public void helper(TreeNode root, int level){
		    // base case 
		        if(root ==null)
		            return;
		        
		    // logic 
		    if(result.size() <= level){
		        result.add(new ArrayList<>());
		     }
		        result.get(level).add(root.val);
		        helper(root.left,level+1);
		         helper(root.right,level+1);
		        
		    }
}
