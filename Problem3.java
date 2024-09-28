
public class Problem3 {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	Time Complexity O(n)
	Space Complexity O(1)
	  
	 List<Integer> rightside = new ArrayList();
	    
	    public void helper(TreeNode node, int level) {
	        if (level == rightside.size()) 
	            rightside.add(node.val);
	        
	        if (node.right != null) 
	            helper(node.right, level + 1);  
	        if (node.left != null) 
	            helper(node.left, level + 1);
	    }    
	    
	    public List<Integer> rightSideView(TreeNode root) {
	        if (root == null) return rightside;
	        
	        helper(root, 0);
	        return rightside;
	    }
	    
//	     public List<Integer> rightSideView(TreeNode root) {
//	           List<Integer> list = new ArrayList<>();
//	         if(root==null)
//	             return list;
	        
//	        ArrayDeque<TreeNode> que = new ArrayDeque<>();
//	         que.add(root);
	        
//	        while(!que.isEmpty()){
//	            int quesize = que.size();
//	            for(int i=0;i<quesize;i++){
//	            TreeNode node = que.poll();
//	                if(i==quesize-1){
//	                    list.add(node.val);
//	                }
	               
//	                if(node.left!=null){
//	                    que.add(node.left);
//	                }
//	                if(node.right!=null){
//	                    que.add(node.right);
//	                }
//	            }
	           
//	        }
	        
//	         return list;
//	     }
	
}
