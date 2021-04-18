/**
Time complexity: O(n)
Space complexity: O(h)
Execute successfully on Leetcode: Yes
Any problems faced: No
*/
class Solution {
    /**
    Approach using DFS:
    - DFS solution uses recursion, hence, the extra space will be the recursive stack.
    - We need to keep track of the level explicitly when we solve this problem using DFS.
    - In the helper dfs method:
      * We pass the given root and level = 0 as parameters
      * We create a new list inside the result list if the level == the size of the result array.
      * We add all the nodes present at that level into the corresponding list inside the result list
      * Recursion continues with the root.left and root.right
    */
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int lvl) {
        if(root == null) {
            return;
        }
        if(lvl == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(lvl).add(root.val);
        dfs(root.left, lvl + 1);
        dfs(root.right, lvl+1);
    }
}
