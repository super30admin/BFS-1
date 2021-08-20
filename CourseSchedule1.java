import java.util.Set;

//https://leetcode.com/problems/course-schedule/
/*
Time: O(V+E) - we would visit each vertex(course) and each edge(degree) once and only once in the worst case
Space: O(V+E)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class CourseSchedule1 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomingEdge = new int[numCourses]; // 0 means no edge

        for (int[] pre : prerequisites) {
            int target = pre[0];
            incomingEdge[target]++;
        }

        Set<Integer> startSet = new HashSet(); // StartSet initially has nodes without any incoming edge

        for (int course = 0; course < numCourses; course++)
            if (incomingEdge[course] == 0)
                startSet.add(course);

        // No element with zero incomingEdge. Means every course requires a prereq.
        // Return false
        if (startSet.isEmpty())
            return false;

        while (!startSet.isEmpty()) {
            Iterator<Integer> it = startSet.iterator();
            int preReq = it.next();
            startSet.remove(preReq);

            // visit the prereq array, remove all the incoming edges coming from source
            for (int[] pre : prerequisites) {
                int source = pre[1];
                int target = pre[0];

                // visit all targets that have this source as a pre-req and remove the incoming
                // edge of that target
                if (preReq == source) {
                    incomingEdge[target]--;
                    if (incomingEdge[target] == 0)
                        startSet.add(target);
                }
            }
        }

        for (int edge : incomingEdge)
            if (edge != 0)// if prereq still exists
                return false;

        return true;
    }

}
