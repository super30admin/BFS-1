package demo;

import java.util.List;
import java.util.Queue;


//public class TreeNode{
//	int val;
//	      TreeNode left;
//	     TreeNode right;
//	      TreeNode(int x) { val = x; }
//}

public class LevelOrderTraversal {

	 public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> ans = new ArrayList<>();
	        Queue<TreeNode> queue = new LinkedList<>();
	        
	        //edge case
	        if(root == null) return ans;
	        
	        queue.add(root);
	        
	        while(!queue.isEmpty()){
	            List<Integer> tem = new ArrayList<>();
	            
	            int size = queue.size();
	            
	            for(int i=0; i < size ; i++){
	                TreeNode curr= queue.poll();
	                tem.add(curr.val);
	                
	                if(curr.left != null) queue.add(curr.left);
	                if(curr.right !=null) queue.add(curr.right);
	                
	                
	            }
	            ans.add(tem);
	        }
	        
	        return ans;
	    }
	    

	

}
