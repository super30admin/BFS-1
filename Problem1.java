// Problem1 - https://leetcode.com/problems/binary-tree-level-order-traversal/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

class BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i < size; i++){
                TreeNode element;
                element = q.poll();
                if(element.left != null) q.add(element.left);
                if(element.right != null) q.add(element.right);
                list.add(element.val);
                
            }
            res.add(list);
        }
        return res;
    }
}

// DFS Method
// Time Complexity : O(n)
// Space Complexity : O(h).... O(n) worst case
class DFS {
        List<List<Integer>> res;
        public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode root, int depth){
        //bas
        if(root == null) return;
        
        if(depth == res.size()){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}