// Time Complexity : O(V + E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if (numCourses == 1 || prerequisites.length == 0) {
            return true;
        }
        
        int[] indegrees = new int[numCourses];
        
        Map<Integer, List<Integer>> hmap = new HashMap<>();
        
        for (int i=0;i<prerequisites.length;i++) {
            int[] curr = prerequisites[i];
            
            indegrees[curr[0]]++;
            List<Integer> currList = hmap.getOrDefault(curr[1], new ArrayList<>());
            currList.add(curr[0]);
            hmap.put(curr[1], currList);
        }
        
        System.out.println(hmap);
        
        Queue<Integer> q = new LinkedList<>();
        
        int coursesProcessed = 0;
        
        for (int i=0;i<indegrees.length;i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                coursesProcessed++;
            }
        }
        
        while (!q.isEmpty()) {
            int currPopped = q.poll();
            
            if (!hmap.containsKey(currPopped)) {
                continue;
            }
            
            List<Integer> dependents = hmap.get(currPopped);
            
            for (int k=0;k<dependents.size();k++) {
                int dependent = dependents.get(k);
                
                indegrees[dependent]--;
                if (indegrees[dependent] == 0) {
                    q.add(dependent);
                    coursesProcessed++;
                }
            }
        }
        
        return coursesProcessed == numCourses ? true : false;
    }
}