// BFS solution

// time complexity: O(N)
// space complexity: O(W=N) where W is the width of the tree
// run on leetcode: Yes
// issues: None

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int n = queue.size();
            for(int i=0; i<n; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}

// DFS solution

// time complexity: O(N)
// space complexity: O(H=N) where H is the height of the tree
// run on leetcode: yes
// issues: None

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.res = new ArrayList<>();
        if(root == null)
            return res;
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int level){
        //base
        if(root == null)
            return;
        //logic
        if(res.size() == level)
            res.add(new ArrayList<>(Arrays.asList(root.val)));
        else
            res.get(level).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}
