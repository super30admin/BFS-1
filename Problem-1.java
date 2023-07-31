// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Solution 1: Using DFS: level order traversal
// Time : O(n), Space: O(h) for stack
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level){

        if(root == null) return;

        if(result.size == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}

// Solution 2: using BFS
// Time: O(n) Space: O(h) for queue
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> li = new ArrayList<>();
            int size = q.size();
            for(int i =0; i< size; i++){
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            result.add(li);
        }

        return result;

    }
}