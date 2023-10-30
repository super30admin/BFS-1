//# BFS-1
//# Problem 1
//Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this
// BFS approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            results.add(li);
        }
        return results;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this
// DFS approach
class Solution {
    List<List<Integer>> results;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.results = new ArrayList<>();
        helper(root, 0);
        return results;
    }
    private void helper(TreeNode root, int level){
        if(root == null) return;
        if(level == results.size()){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}

// # Problem 2 Course Schedule (https://leetcode.com/problems/course-schedule/)
// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] indegrees = new int[numCourses];
        for(int [] pr: prerequisites){
            int out = pr[1];
            int in = pr[0];
            indegrees[in]++;
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0; i<numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        if(count == numCourses) return true;
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int parent = q.poll();
            List<Integer> child = map.get(parent);
            if(child != null){
                for(int ch: child){
                    indegrees[ch]--;
                    if(indegrees[ch] == 0){
                        q.add(ch);
                        count++;
                    }
                }
            }

        }
        return count == numCourses;
    }
}