// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] edge: prerequisites) {
            indegrees[edge[0]]++;
            // independent to dependent;
            if(!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        if(queue.isEmpty()){
            return false;
        }
        if(count == numCourses) {
            return true;
        }
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            // reduce indegrees of children
            List<Integer> child = map.get(curr);
            if(child != null) {
                for(int c: child) {
                    indegrees[c]--;
                    if(indegrees[c] == 0) {
                        queue.add(c);
                        count++;
                        if(count == numCourses) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}