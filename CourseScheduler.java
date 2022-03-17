import java.util.*;

// Time Complexity : O(V+E) where v is the number of vertcies and E is the number of edges
// Space Complexity : O(max(V,E)) where v is the number of vertcies and E is the number of edges
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
public class CourseScheduler {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;
        int[] inDegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap();
        Queue<Integer> q = new LinkedList();
        int count = 0;
        for (int[] prereq : prerequisites) {
            // having the dependency count for each course
            inDegrees[prereq[0]]++;
            // mapping course to the courses dependent on it.
            if (!map.containsKey(prereq[1])) {// bi
                // course, its dependency
                map.put(prereq[1], new ArrayList());
            }
            map.get(prereq[1]).add(prereq[0]);// add ai
        }
        // checking for independent courses and adding to queue
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }
        if (q.isEmpty())
            return false;
        while (!q.isEmpty() && count < numCourses) { // if all nodes are put in Q, why to process extra nodes- just
                                                     // optimisation
            int course = q.poll();
            List<Integer> dependents = map.get(course);
            if (dependents != null) {
                for (int dependent : dependents) {
                    inDegrees[dependent]--;
                    if (inDegrees[dependent] == 0) { // if becomes independent
                        q.add(dependent);
                        count++;
                    }
                }
            }

        }
        return count == numCourses;
    }
}
