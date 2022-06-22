// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);   
    }
}
/*class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            //process each node for a specific level
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(li);
        }
        return result;
    }
}
*/