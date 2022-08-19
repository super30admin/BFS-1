// Time Complexity : O(n)
// Space Complexity : O(n/2) ==> O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    //Level Order Traversal Using BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        //result list [[], [], []]
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++){
                //Remove from Queue
                TreeNode curr = q.poll();
                //Add to temp list
                temp.add(curr.val);
                
                //put the babies of a curr in a queue
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                //System.out.println(temp);
                
            }
            result.add(temp);
            System.out.println(temp);
        }
        
        return result;          
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
class Solution {
    //Level Order Traversal Using DFS
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        //result list [[], [], []]     
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,0);
        return result;
    }
    
    public void dfs(TreeNode root, int depth){
        //base
        if(root == null) return;
        //logic
        if(depth == result.size()){
            result.add(new ArrayList<>());
        }
        
        result.get(depth).add(root.val);
        
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}


// Time Complexity : O(n)
// Space Complexity : O(h)
class Solution 
{
    //Level Order Traversal Using Stack,  Pre Order Traversal Root Right Left
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        //result list [[], [], []]    
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> depSt = new Stack<>();
        st.push(root); //3
        depSt.push(0); 
        
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            int d = depSt.pop(); // Current depth of the Tree
            
            if(d == result.size()){
               result.add(new ArrayList<>());
            }
            result.get(d).add(curr.val);
            if(curr.right != null){
                st.push(curr.right);
                depSt.push(d+1);
            }
            if(curr.left != null){
                st.push(curr.left);
                depSt.push(d+1);
            }
        }
        return result;
    }

}