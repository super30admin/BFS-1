// Time complexity: O(numCourses).
// Space complexity: O(numCourses) for queue.

import java.util.*;

class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>(); 
        
        int indegree[] = new int[numCourses]; 
        for(int[] pr: prerequisites) {
            List<Integer> list = map.getOrDefault(pr[1], new ArrayList<>());
            list.add(pr[0]); 
            map.put(pr[1], list);
            
            indegree[pr[0]]++; 
        }
        
        Queue<Integer> queue = new LinkedList<>(); 
        for (int course = 0; course < numCourses; course++) {
            // adding courses with no prerequisites to the queue
            if(indegree[course] == 0) {
                queue.offer(course); 
            }
        }
                
        int numCoursesTaken = 0; 
        while(!queue.isEmpty()) {
            int course = queue.poll();
            numCoursesTaken++; 
            if(map.containsKey(course)) {
                for (int newCourse : map.get(course)) {
                    // decrementing the indegree for which prerequisite is satisfied.
                    indegree[newCourse]--;
                    // adding course if all prerequisites are taken.
                    if (indegree[newCourse] == 0) {
                        queue.offer(newCourse); 
                    }
                }
            }   
        }
        
        // return true if all courses are taken
        return numCoursesTaken == numCourses; 
    }
}