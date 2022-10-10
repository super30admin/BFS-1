// Approach - 1
class Solution {
    // DFS solution
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) 
            return result;
        Traverse(result, root, 0);
        return result;
    }
    
    private void Traverse(List<List<Integer>> result, TreeNode root, int level) {
        // base
        if (root == null) return ;
        // logic
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) 
            Traverse(result, root.left, level+1);
        if (root.right != null)
            Traverse(result, root.right, level+1);
    }
}
// Executed
// S.C : O(h) -> height of the tree
// T.C : O(n)

// Approach - 2 using Breadth first traversal
class Solution {
    // T.C : O(n)
    // S.C : O(h)
    // Executed
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}