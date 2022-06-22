// https://leetcode.com/problems/course-schedule/

// Time Complexity: O(V + E)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Null condition
        if(prerequisites == null || prerequisites.length == 0) return true;
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] edge: prerequisites) { // O(E)
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }
        
        while(!q.isEmpty() && count < numCourses) {
            int curr = q.poll();
            // indegrees of dependant nodes
            List<Integer> li = map.get(curr);
            if(li != null) {
                for(int edge: li) {
                    indegrees[edge]--;
                    if(indegrees[edge] == 0) {
                        q.add(edge);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
            if(count == numCourses) return true;
        }
        
        return false;
    }
}