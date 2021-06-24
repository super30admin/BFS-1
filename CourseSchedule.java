// Time Complexity : O(v + e)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

/**
 * In this problem, we have constructed the indegree array for the courses.
 * We take the BFS approach and process the courses with no dependent couses first (indegree value == 0)
 * once an independent course is completed, we decrement it from the dependent courses in the indegree array.
 * We keep the dependent courses in a hashmap. 
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> dependency_list_map = new HashMap<>();
            
        // construct the indegree array and the adjacency list
        for(int[] prereq: prerequisites) {
            int in = prereq[0];
            int out = prereq[1];
            
            indegree[in]++;
            
            if(!dependency_list_map.containsKey(out)) {
                dependency_list_map.put(out, new ArrayList<>());
            }
            
            dependency_list_map.get(out).add(in);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        // add the courses which are independent
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        // if there are no independent courses
        if(q.size() == 0) return false;
        
        int count = 0;
        
        while(!q.isEmpty()) {
            int processing = q.poll();
            count++;
            
            List<Integer> dependents = dependency_list_map.get(processing);
            
            if(dependents != null) {
                for(int dep: dependents) {
                    indegree[dep]--;
                    if(indegree[dep] == 0) {
                        q.add(dep);
                    }
                }
            }
        }
        
        return count == numCourses;
    }
}
