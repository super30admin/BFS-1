// Time Complexity : O(N)
// Space Complexity : O(N)  //width of tree O(N/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//BFS Solution
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                temp.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(H)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//DFS Solution
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result=new ArrayList<>();
        if(root==null){
            return result;
        }
        dfs(root, 0);
        return result;
    }
    public void dfs(TreeNode root, int level){
        if(root==null){
            return;
        }
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}