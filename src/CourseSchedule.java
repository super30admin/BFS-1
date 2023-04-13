// Time Complexity:           O(V + E)
// Space Complexity:          O(V + E)
// where n is number of nodes in tree, h is height of the tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement


import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] prereq : prerequisites) {

            int dependent = prereq[0];
            int source = prereq[1];

            if(!adjList.containsKey(source)) {
                adjList.put(source, new ArrayList<>());                          // making adjacency list
            }

            adjList.get(source).add(dependent);                                  // updating adjacency list

            indegree[dependent]++;                                               // updating indegrees

        }

        Queue<Integer> q = new LinkedList<>();                                   // queue maintaining independent nodes

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);                                                        // adding independent nodes in queue
            }
        }

        int completedCourses = 0;                                                
        while(!q.isEmpty()) {
            int course = q.remove();                                             // getting independent course one by one
            completedCourses++;                                                  // updating completed courses

            List<Integer> dependentCourses = adjList.get(course);                // getting adjacency list of independent node

            if(dependentCourses != null) {
                for(int dependent : dependentCourses) {                          // getting dependent courses of nodes out of adjacncy list one by one
                    indegree[dependent]--;                                       // updating indegrees
                    if(indegree[dependent] == 0) {                               // if node becomes independent
                        q.add(dependent);                                        // add it to queue
                    }
                }
            }
        }
        return completedCourses == numCourses;                                   // if completed courses is equal to total courses, return true; or else false
    }
}
