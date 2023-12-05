import java.util.*;

public class CourseSchedule {
//    Topological Sort in Directed Acyclic Graph
    // Time Complexity: O(V + E) where V is the number of vertices (numCourses) and E is the number of edges (prerequisites).
    // Space Complexity: O(V + E) for the adjacency list and indegrees array.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Initialize indegree array to track incoming edges to each vertex
        int[] indegrees = new int[numCourses];

        // Step 2: Create an adjacency list to represent the directed graph
        // where key = prerequisite course and value = list of courses dependent on the key course
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Step 3: Count the number of courses that can be taken
        int count = 0;

        // Step 4: Populate indegrees array and adjacency list
        for(int[] pr : prerequisites) {
            indegrees[pr[0]]++; // Increment the indegree of the course being depended upon
            if (!map.containsKey(pr[1])) {
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]); // Add the dependent course to the adjacency list
        }

        // Step 5: Initialize a queue for BFS and add courses with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }

        // Step 6: Perform BFS
        while(!q.isEmpty()) {
            Integer course = q.poll();
            List<Integer> li = map.get(course);
            if(li != null) {
                for(Integer i: li) {
                    indegrees[i]--; // Decrement indegree of the dependent course
                    if(indegrees[i] == 0) {
                        q.add(i); // Add to the queue if indegree becomes 0
                        count++;
                        if(count == numCourses) return true; // All courses can be taken
                    }
                }
            }
        }

        // Step 7: Check if all courses can be taken (count matches numCourses)
        return count == numCourses;
    }
}
