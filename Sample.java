# Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root); 

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> answer = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                answer.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(answer);
        }
        return result;
    }
}


# Problem 2
Course Schedule (https://leetcode.com/problems/course-schedule/)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegrees = new int[numCourses];
        int count = 0;

        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            int to = prerequisite[0];
            int from = prerequisite[1];
            indegrees[to]++;

            if(!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        } 
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if (edges == null) {
                continue;
            }
            for (int i = 0; i < edges.size(); i++) {
                int edge = edges.get(i);
                indegrees[edge]--;
                if (indegrees[edge] == 0) {
                    q.add(edge);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}