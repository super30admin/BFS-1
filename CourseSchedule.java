/* Approach 1: BFS */

// Time Complexity : O(E+V) where E = Edges & V = Vertices
// Space Complexity : O(E+V) 
// Did this code successfully run on Leetcode : Yes

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // in degree array
        int[] indegrees = new int[numCourses];
        // Hashmap to store vertices(subjects) & subjects dependent on respective vertices
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for (int edge[]: prerequisites) {
            indegrees[edge[0]]++; //dependency count
            if(!map.containsKey(edge[1]))
                map.put(edge[1],new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }
        
        // BFS
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        for (int i = 0; i< numCourses; i++){    // add all subjects without any prerequisites
            if (indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }
        
        if (count == numCourses) return true;   
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> dependentSub = map.get(curr); // all subjects with prerequisites as curr
            if(dependentSub != null){
                for (int sub: dependentSub) {
                    indegrees[sub]--;
                    if (indegrees[sub] == 0){
                        q.add(sub);
                        count++;
                    }
                }
            }
        }
        if (count == numCourses) return true;
        return false;
    }
}
