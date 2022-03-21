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
                adjList.put(source, new ArrayList<>());
            }

            adjList.get(source).add(dependent);

            indegree[dependent]++;

        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int completedCourses = 0;
        while(!q.isEmpty()) {
            int course = q.remove();
            completedCourses++;

            List<Integer> dependentCourses = adjList.get(course);

            if(dependentCourses != null) {
                for(int dependent : dependentCourses) {
                    indegree[dependent]--;
                    if(indegree[dependent] == 0) {
                        q.add(dependent);
                    }
                }
            }
        }
        return completedCourses == numCourses;
    }
}