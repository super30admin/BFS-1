// Time Complexity : O(V + E) --> where V is vertices and E is edges in the given graph
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode (207): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        int indegree[] = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for (int edge[] : prerequisites) {
            indegree[edge[0]]++;    
            if (!map.containsKey(edge[1])) map.put(edge[1], new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        
        if (q.size() == 0) return false;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if (children != null) {
                for (int child : children) {
                    indegree[child]--;
                    if (indegree[child] == 0) q.add(child);
                }
            }
        }
        
        // just check if any subject is left in indegree array with any pre-requisite
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] > 0) return false;
        }
        return true;
    }
}