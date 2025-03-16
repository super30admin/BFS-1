import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Time Complexity: O(V + E) where V is number of courses and E is the connection between them
 * Space Complexity: O(V + E) V for the indegrees array and E for adjacency list
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Topological Sort Using Kahn's Algorithm (BFS)
 * 
 * Initialize:
 * 1. dependencies: An indegree array to track prerequisite counts for each course.
 *  map: An adjacency list to represent the course dependency graph.
 * 2. Populate the indegree array and adjacency list by iterating over the prerequisites.
 * 3. Add courses with zero dependencies to the queue and increment the count.
 * 4. Process the queue by decrementing dependencies for each course's dependents. 
 * 5. If any dependent course's dependency count reaches zero, add it to the queue.
 * 6. Return true if all courses are processed (count == numCourses), indicating no cycles.
 * 7. Return false if a cycle exists, preventing some courses from being completed.
 */

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        int[] dependencies = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prereq: prerequisites) {
            int dependent = prereq[0];
            int independent = prereq[1];
            
            // 1. populate dependencies indegrees array
            dependencies[dependent]++;

            // 2. populate adjacency list
            if (!map.containsKey(independent)) {
                map.put(independent, new ArrayList<>());
            }

            map.get(independent).add(dependent);
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i< numCourses;i++) {
            if (dependencies[i] == 0) {
                q.add(i);
                count++;
            }
        }

        while (!q.isEmpty()) {
            //1. reduce the dependencies
            int curr = q.poll();
            if(map.containsKey(curr)) {
                List<Integer> values = map.get(curr);
                for (int index: values) {
                    dependencies[index]--;

                    if (dependencies[index] == 0) {
                        // 2. if dependency is 0 add that node to queue
                        q.add(index);
                        count++;
                    }
                }  
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        // Your code here
        CourseSchedule obj = new CourseSchedule();
        boolean canFinish = obj.canFinish(6, new int[][]{{1,2}, {2,3}, {3,4}, {4,5}});
        assert (canFinish == true);
    }
}