/*
Time Complexity: O(V + E)
where V is the number of vertices (courses) and E is the number of edges (prerequisites).
Space Complexity: O(V + E)
where V is the number of vertices (courses) and E is the number of edges (prerequisites).
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Intuition: Use BFS to traverse the graph and check if all courses can be completed.

*/

import java.util.*;
import java.util.LinkedList;

//BFS approach 
class CourseScheduleBFS {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] degrees = new int[numCourses];//

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {

            degrees[prerequisites[i][1]]++; //

            if (!map.containsKey(prerequisites[i][0])) {

                map.put(prerequisites[i][0], new ArrayList<>());

            }

            map.get(prerequisites[i][0]).add(prerequisites[i][1]);

        }

        for (int i = 0; i < degrees.length; i++) {

            if (degrees[i] == 0) {

                q.add(i);

            }

        }

        while (!q.isEmpty()) {

            int course = q.poll();

            List<Integer> children = map.get(course);

            if (children != null) {

                for (Integer child : children) {

                    degrees[child]--;

                    if (degrees[child] == 0) {

                        q.add(child);

                    }

                }

            }

        }

        for (int i = 0; i < degrees.length; i++) {

            if (degrees[i] != 0)
                return false;

        }

        return true;

    }

}

// DFS approach
class CourseScheduleDFS {
    class Solution {
        HashSet<Integer> visited = new HashSet();
        HashMap<Integer, List<Integer>> coursePreMap = new HashMap();
    
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            for(int [] rec: prerequisites){
                int course = rec[0];
                int pre = rec[1];
    
                if(!coursePreMap.containsKey(course)){
                    coursePreMap.put(course, new ArrayList());
                }
                coursePreMap.get(course).add(pre);
                //coursePreMap.computeIfAbsent(course, k -> new ArrayList()).add(pre);
            }
    
            for(int i =0; i < numCourses; i++){
                if(!dfs(i))
                    return false;
            }
            return true;
        }
    
        private boolean dfs(int course){
            if(coursePreMap.get(course) == null || coursePreMap.get(course).isEmpty())
                return true;
            
            if(visited.contains(course))
                return false;
    
            visited.add(course);
            for(int pre: coursePreMap.get(course)){
                if(!dfs(pre))
                    return false;
            }
            visited.remove(course);
            coursePreMap.put(course, new ArrayList());
            return true;
        }
    }
