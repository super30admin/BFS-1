// Time Complexity : O(V+E)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We form the indegree array as well as the adjacency matrix.
    We run a BFS to check if all the courses can be completed.
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int [] indegrees = new int [numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int [] prerequisite : prerequisites){
            indegrees[prerequisite[0]]++;
            List<Integer> li = map.getOrDefault(prerequisite[1], new ArrayList<>());   
            li.add(prerequisite[0]);
            map.put(prerequisite[1],li);
        }
        
        int count = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0; i<numCourses; i++){
            if (indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        
        while (!q.isEmpty()){
            Integer i = q.poll();

            if (map.containsKey(i)){
                for (Integer j : map.get(i)){
                    indegrees[j]--;
                    if (indegrees[j] == 0){
                        q.add(j);
                        count++;
                    }
                }
            }
            
        }
        
        if (count == numCourses)
            return true;
        
        return false;
    }
}