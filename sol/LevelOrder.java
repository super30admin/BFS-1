package sol;


import java.util.*;	

public class LevelOrder {
	
	 public class TreeNode {
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
	
	
	 public List<List<Integer>> levelOrder(TreeNode root) {
	        
	        
	        Queue <TreeNode> q= new LinkedList(); 
	        List<List<Integer>>l1= new LinkedList();
	        
	        if(root==null){return l1;}
	        q.add(root);
	       
	        
	        while(!q.isEmpty()){
	            
	           int counter=q.size();
	       List<Integer> l= new LinkedList<>();     
	            while(counter>0){
	                
	                TreeNode out=q.poll();
	                l.add(out.val);
	                
	                if(out.left!=null){
	                    
	                    q.add(out.left);
	                }
	                
	                if(out.right!=null){
	                    q.add(out.right);
	                }
	                counter--;
	            }
	            l1.add(l);
	        
	    }

	    return l1;
	    
	    }

}
