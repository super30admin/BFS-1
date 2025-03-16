import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Using BFS
Time COmplexity -> O(N)
Space COmplexity -> O(N)
*/
class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> ans = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                ans.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        result.add(ans);
        }
        return result;
    }
}

/*
Using DFS 
Time COmplexity -> O(N)
Space COmplexity -> O(H)
*/


class Solution2 {
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            List<Integer> ans = new ArrayList<>();
            ans.add(root.val);
            result.add(ans);
        } else {
            result.get(level).add(root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}