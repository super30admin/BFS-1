import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // TC : O(n) // SC: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return result;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                li.add(curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            result.add(li);
        }
        return result;
    }

    // TC : O(n) // SC : O(V+E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int[] dependency = new int[numCourses];

        for (int[] pr : prerequisites) {
            dependency[pr[0]]++;

            if (!map.containsKey(pr[1])) {
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < dependency.length; i++) {
            if (dependency[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        if (queue.isEmpty())
            return false;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> li = map.get(curr);
            if (li != null) {
                for (Integer i : li) {
                    dependency[i]--;
                    if (dependency[i] == 0) {
                        queue.add(i);
                        count++;
                    }
                    if (count == numCourses)
                        return true;
                }
            }
        }
        return false;
    }

}