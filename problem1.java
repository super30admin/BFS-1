//T.C-O(n)
//S.C-O(n){as in worst case it could be skewed tree}
//passed all test cases
// the approach is to use level variable and traverse using dfs. 
class Solution {
    public void helper(TreeNode root, List<List<Integer>> al, int level) {
        if (root == null)
            return;
        if (level == al.size()) {
            al.add(new ArrayList<>());
        }
        al.get(level).add(root.val);
        helper(root.left, al, level + 1);
        helper(root.right, al, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<List<Integer>>();
        helper(root, al, 0);
        return al;
    }
}
