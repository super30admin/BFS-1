
public class Problem1 {
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
	
	      public List<List<Integer>> levelOrder(TreeNode root) {
	          List<List<Integer>> levels= new ArrayList<>();
	          
	          if(root==null) return levels;
	          
	          Queue<TreeNode> queue = new LinkedList<>();
	          queue.add(root);
	          while(!queue.isEmpty()){
	          
	              int queSize= queue.size();
	              List<Integer> temp = new ArrayList<>();
	              for(int i=0;i<queSize;i++){
	                TreeNode node = queue.poll();
	                  temp.add(node.val);
	                  if(node.left!=null){
	                      queue.add(node.left);
	                    
	                  }
	                  if(node.right!=null){
	                      queue.add(node.right);
	                   
	                  }
	              }
	              levels.add(temp);
	          }
	          return levels;
	      }
	    

	    
//	    List<List<Integer>> levels = new ArrayList<List<Integer>>();

	//   public void helper(TreeNode node, int level,List<List<Integer>> levels) {
//	                 if(node==null)
//	                     return;
//	                 if(levels.size()==level){
//	                    levels.add(new ArrayList<>());
//	                 }
//	                 levels.get(level).add(node.val);
	      
//	              helper(node.left, level+1,levels);
//	              helper(node.right, level+1,levels);
//	     }
	    
//	     public List<List<Integer>> levelOrder(TreeNode root) {
//	            List<List<Integer>> levels = new ArrayList<List<Integer>>();
//	         if (root == null) return levels;
//	         helper(root, 0,levels);
//	         return levels;
//	     }
	  
	
}
