/*
    LC - 102. Binary Tree Level Order Traversal
    TC - o(n)
    SC - o(n) - denotes the queue size
*/


// Using BFS

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) {
            return result;
        }

        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            
            int len = q.size();
            for(int i=0; i<len; i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                } 
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}

// Using DFS
/* 
    TC - o(n)
    SC - o(h) - height of the tree
*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    public void dfs(TreeNode root, int level){
        if(root == null) {
            return;
        }
        if(level == result.size()) {
            List<Integer> temp = new ArrayList<>();
            result.add(temp); 
        }
        result.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}