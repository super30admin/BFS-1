/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /**
 * Time Complexity: O(V+E)
 * Space Complexity: O(N)
 * Accepted on Leetcode: Yes
 
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< prerequisites.length; i++){
            indegrees[prerequisites[i][1]]++;
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0], new ArrayList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i = 0 ; i<indegrees.length; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
            
        }
        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> children = map.get(course);
            if(children!=null){
            for(int child : children){
                indegrees[child]--;
                if(indegrees[child] == 0)
                    q.add(child);
            }
            }
        }
        for(int i = 0 ; i<indegrees.length; i++){
            if(indegrees[i] > 0){
                return false;
            }
        }
        return true;
    }
}