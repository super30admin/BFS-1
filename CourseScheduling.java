
// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
//Determine the prereq in form of a map whose value is adjList
//Make root as no depedency course and add to queue
//Add depedency and poll based on count and processing its indegrees
//If alll are 0 return true or return false

import java.util.*;

class CourseScheduling {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }
        int count=0;
        int [] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<prerequisites.length;i++){
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            inDegree[to]++;
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
                count++;
            }
        }
        while(!queue.isEmpty()){
            int courses = queue.poll();
            if(map.containsKey(courses)){
                for(int edge : map.get(courses)){
                    inDegree[edge]--;
                    if(inDegree[edge] == 0){
                        queue.add(edge);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}