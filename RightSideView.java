/**
Problem: Right side view of the tree
Did it run on Leetcode: Yes
Time Complexity : O(n), where n is the number of nodes
Space Complexity: O(n), where n is the number of nodes in the tree, for both bfs, and dfs.

Approach 1 : BFS
1. We use a queue to implement BFS. We add the root to the queue first.
2. To the result list, we add the last element of a given level, because it is what is visible from the right side.
3. To do this, we check if the current queue size is equal to the current level of the tree. Only if it is equal we add the node to the list.

Approach 2: DFS
1. We implement the same method, but using recursive traversal. 
2. We add elements to the result list only when the current level matches the size of the result array.
*/

//BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i<size; i++) {
                TreeNode curr = q.poll();
                if(i == size - 1) {
                    result.add(curr.val);
                }
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return result;
    }
}

//DFS
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root,0);
        return result;
    }
    public void dfs(TreeNode root, int level) {
        //base case
        if(root == null) {
            return;
        }
        if(level == result.size()) {
            result.add(root.val);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}
        