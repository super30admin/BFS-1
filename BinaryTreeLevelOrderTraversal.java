// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//using BFS: Queue, size variable, list: result
//insert child nodes into the queue
//find the size queue == level
//pop till size is zero or for 0 to size: insert its child into the queue
//repeat...

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
       if(root==null) return result;
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
           List<Integer> temp = new ArrayList<>();
           int count = q.size();
           for(int i=0;i<count;i++){
               TreeNode node = q.poll();
               temp.add(node.val);
               if(node.left!=null)
               q.add(node.left);
               if(node.right!=null)
               q.add(node.right);
           }
           result.add(temp);
       }
       return result;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(h) space required by the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Using DFS: Recursion:: list, local variable height

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        dfs(root,0);
        return result;
    }

    private void dfs(TreeNode root, int height){
       if(root==null) return ;
       
       //logic
       if(height==result.size()){
           result.add(new ArrayList<>());
       }
       result.get(height).add(root.val);
       dfs(root.left,height+1);
       dfs(root.right,height+1);
   }
} 
    


