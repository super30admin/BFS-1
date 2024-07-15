# BFS-1
# Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

# Problem 2
Course Schedule (https://leetcode.com/problems/course-schedule/)


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }                
            }    
            
            result.add(level);
        }
        
        return result;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : yes

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> mp = new HashMap<>();

        if (numCourses < 2)
            return true;

        int m = prerequisites.length;
        int n = prerequisites[0].length;

        boolean ans = true;
        for (int i=0;i<m;i++){
                if (mp.containsKey(prerequisites[i][0])){
                    System.out.print(mp.get(prerequisites[i][0]) + " ");
                    System.out.println(prerequisites[i][1]);
                    if (mp.get(prerequisites[i][0]) == prerequisites[i][1])
                        return false;
                } else {
                    System.out.print(prerequisites[i][1] + " ");
                    System.out.println(prerequisites[i][0]);
                    
                    mp.put(prerequisites[i][1], prerequisites[i][0]);
                }
        }
        return ans;
    }
}