
// BFS
public class LevelOrderTraversalBFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
           int size = q.size();
           List<Integer> temp = new ArrayList<>();
          for(int i=0;i<size;i++){
            TreeNode curr = q.poll();
            temp.add(curr.val);
            
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
          }
          result.add(temp);  
        }
       return result; 
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)

public class LevelOrderTraversalDFS {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root==null) return result;
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root, int depth){
        // base case
        if(root==null) return;
        
        // logic
        if(depth==result.size()){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}

// Time Complexity - O(n)
// Space Complexity - O(h)