// Time Complexity : O(n)n=number of elements in  tree . 
// Space Complexity : O(max Witdth of the tree) because we use extra data structure for List<TreeNode> tmp = new ArrayList<>();
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the first step just add the root to list, then iterate until list is empty. at each level traverse the children and add to tmp list.
// if children left or right is not null add it to level result; at the end of each level add result level to final result;
//Success
//Details 
//Runtime:Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
//Memory Usage: 39.5 MB, less than 5.33% of Java online submissions for Binary Tree Level Order Traversal.
  public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) return new ArrayList<>();

      List<TreeNode> list = new ArrayList<>();
      List<List<Integer>> result = new ArrayList<>();
      list.add(root);
      List<Integer> resultLevel = new ArrayList<>();
      resultLevel.add(root.val);
      result.add(resultLevel);

      while (list.size() > 0) {
        resultLevel = new ArrayList<>();
        List<TreeNode> tmp = new ArrayList<>();
        for (TreeNode node : list) {
          if (node.left != null) {
            resultLevel.add(node.left.val);
            tmp.add(node.left);
          }
          if (node.right != null) {
            resultLevel.add(node.right.val);
            tmp.add(node.right);
          }
        }
        if (resultLevel.size()>0)
          result.add(resultLevel);  
       
        list = tmp;
      }
      return result;
        
    }
	
// 2) another solution for BFS

// Time Complexity : O(n)n=number of elements in  tree . 
// Space Complexity : O(max Witdth of the tree) because we use extra data structure for Queue;
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the first step just add the root to list, then iterate until list is empty. at each level traverse the children and add to tmp list.
// if children left or right is not null add it to level result; at the end of each level add result level to final result;
//Success
//Details 
//Runtime:Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
//Memory Usage: 39.5 MB, less than 5.33% of Java online submissions for Binary Tree Level Order Traversal.
	class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) return new ArrayList<>();
      result = new ArrayList<>();
      Queue<TreeNode> queue= new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()){
         int size = queue.size();
         List<Integer> tmp=new ArrayList<>(); 
         for (int i=0;i<size;i++){
             TreeNode node=queue.poll();
             tmp.add(node.val);
             if (node.left!=null)
               queue.add(node.left);
             if (node.right!=null)
               queue.add(node.right);
         }
         result.add(tmp);
      }
	  return result;
    }
}
	
	
	
	
	
// 3) solution with DFS -recursion

// Time Complexity : O(n)n=number of elements in  tree . 
// Space Complexity : O(max depth of the tree) because we use recursive stack;
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//we use recursion and we pass the level in the recursion, if level == to size of result list, add new arraylist, then add element to that position(level) in list;
//Success
//Details 
//Runtime:Runtime: Runtime: 1 ms, faster than 56.79% of Java online submissions for Binary Tree Level Order Traversal.
// Memory Usage: 40.4 MB, less than 5.33% of Java online submissions for Binary Tree Level Order Traversal.
  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> levelOrder(TreeNode root) {
	dfs(root,0)
	return result;
  }
  
  private void dfs(TreeNode root, int level){
	  //base case
	  if (root==null)
		  return ;
	  if (level == result.size())
		  result.add(new ArrayList<Integer>());
	  result.get(leve).add(root.val);
	  dfs(root.left,level+1);
	  dfs(root.right,level+1);
	  
  }