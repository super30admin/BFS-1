import java.util.*;

public class CourseSchedule {

    // TC: O(V + E) => V - number of vertices    E - number of edges
    // SC: O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // prerequisites.length = 0 meaning no prerequisites. So, can finish the semester
        if(prerequisites == null || prerequisites.length == 0) return true;

        // This map will store the mapping of prerequisite and the list of courses dependent on it.
        Map<Integer, List<Integer>> map = new HashMap<>();

        // An array to track given a course i, how many courses it is dependent on
        // [2,0] - 2 has a prerequisites on 0. So, increment the counter in this array for course #2
        int[] inDegrees = new int[numCourses];

        for(int[] edge : prerequisites) {
            inDegrees[edge[0]]++;

            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }

        int countOfCoursesCanComplete = 0;

        // Queue will hold all the elements which have indegree as 0
        // meaning all those courses which don't have any dependency will be put in queue
        // It also means all the courses which can be completed will be put in a queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
                countOfCoursesCanComplete++;
            }
        }

        // It means we don't have any course which doesn't have any prereq
        if(queue.isEmpty()) return false;

        while(!queue.isEmpty()) {
            int currentCourse = queue.poll();
            List<Integer> edges = map.get(currentCourse);
            if(edges != null) {
                for(int edge : edges) {
                    inDegrees[edge]--;
                    if(inDegrees[edge] == 0){
                        queue.add(edge);
                        countOfCoursesCanComplete++;
                    }

                }
            }

        }

        return countOfCoursesCanComplete == numCourses;
    }
}
