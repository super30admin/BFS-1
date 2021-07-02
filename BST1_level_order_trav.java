

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


/*
 * 
 *  
 Time Complexity : O(n)
 Space Complexity : O(n)
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this :
Your code here along with comments explaining your approach: used BFS 
 * 
 * */


public class BST1_level_order_trav {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (root == null) return result;
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        
	        while(!q.isEmpty()){
	            int size = q.size();
	            List<Integer> list = new  ArrayList<>();
	           
	            for(int i = 0; i < size; i++ ){
	                TreeNode curr = q.poll();
	                list.add(curr.val);
	                if(curr.left!= null) q.add(curr.left);
	                if(curr.right!= null) q.add(curr.right);
	            }
	            result.add(list);
	        }
	        return result;
	    }
	}


/**
 * 
 * Time Complexity : O(n)
 Space Complexity : O(n)
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this :
Your code here along with comments explaining your approach: used DFS Solution Below
 */
class BST1_level_order_trav {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
            
       // List <Integer> li = new ArrayList<>();
       // result.add(new ArrayList<Integer>()) ;
        dfs(root, 0, result);
        return result;
    }
    
    private void dfs (TreeNode root, int level, List<List<Integer>> result ){
        //base case
        if(root == null) return;
        
        if(level == result.size()){
           result.add(new ArrayList<Integer>()) ;
        }

         result.get(level).add(root.val);
          System.out.println(root.val);
        dfs(root.left, level+1, result);
     
        dfs(root.right, level+1, result);
        
        
    }
    
    
}
















