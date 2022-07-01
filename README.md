# BFS-1
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
    //TC O(n) SC O(n) BFS
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> list = new ArrayList<>();
            
            for(int i =0; i< s; i++){
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left !=null){
                    q.add(curr.left);
                }
                if(curr.right !=null){
                    q.add(curr.right);
                }  
            }
           result.add(list); 
        }
        return result;
    }
}


# Problem 2
Course Schedule (https://leetcode.com/problems/course-schedule/)

class Solution {
    // TC O(V+E) SC O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int edge[] : prerequisites){
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
            
        }
        if(q.isEmpty()) return false;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if(edges != null){
                for(int edge: edges){
                    indegrees[edge]--;
                    if(indegrees[edge] == 0){
                        q.add(edge);
                        count++;
                    }
                }
                
            }
            
            
        }
        return count == numCourses;
    }
}
