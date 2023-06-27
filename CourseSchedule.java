// Time Complexity :O(V+E) where V = numofCOurses and E is the length of the prerequisites array
// Space Complexity : O(V+E) here V = numofCOurses and E is the length of the prerequisites array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

import java.util.*;
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length < 1){
            return true;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites)
        {
            if(!map.containsKey(pre[1])){
                map.put(pre[1], new ArrayList<Integer>());
            }
            map.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i <numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int current = q.poll();
            count++;
            if(count == numCourses) return true;

            if(map.containsKey(current)){
                List<Integer> dependentNodes = map.get(current);
                for(int i = 0; i< dependentNodes.size(); i++){
                    indegree[dependentNodes.get(i)]--;
                    if(indegree[dependentNodes.get(i)] == 0){
                        q.add(dependentNodes.get(i));
                    }
                }
            }
        }
        return false;
    }
}