// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Here we create a queue and add root to it. We maintain a size variable to distinguish the levels. if the left and right child are present then
//we add them to the queue and add them to a list. once we have all the nodes in a level we add it to the result list.
//bfs solution
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if(root == null)return result;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left !=null){
                    q.add(curr.left);    
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                li.add(curr.val);
            }
            result.add(li);
        }
        return result;       
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
//dfs solution
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)return result;
        dfs(root,0);
        return result;      
    }
    private void dfs(TreeNode root, int depth){
        if(root == null)return;
        if(result.size() == depth){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
 
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}