import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// TC - O(V+E) => O(max(V,E))
// SC - O(V+E) => O(max(V,E)) => Map<Vertex, List<Edges>>

// Constraints:
// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.

public class CourseSchedule {
    class Solution {
        private int[] indegreeArray;
        private Map<Integer, List<Integer>> courseToDepedentsMap;
        private Queue<Integer> queue;
        private int totalCoursesDone;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            this.indegreeArray = new int[numCourses]; // currCourse depends on how many courses
            this.courseToDepedentsMap = new HashMap<>(); // which courses are dependent on currCourse
            this.queue = new LinkedList<>();

            for (int[] preReqPair : prerequisites) {
                int course = preReqPair[0];
                int preReq = preReqPair[1];
                indegreeArray[course]++;
                if (!courseToDepedentsMap.containsKey(preReq)) {
                    courseToDepedentsMap.put(preReq, new ArrayList<>());
                }
                courseToDepedentsMap.get(preReq).add(course);
            }

            for (int i = 0; i < numCourses; i++) {
                if (indegreeArray[i] == 0) {
                    queue.add(i);
                    totalCoursesDone++;
                }
            }

            while (!queue.isEmpty()) {
                int currCourse = queue.poll();
                // depedentCoursesList = null for courses who are not a pre-requisite
                // Map does not have an entry for those
                if (courseToDepedentsMap.containsKey(currCourse)) {
                    List<Integer> depedentCoursesList = courseToDepedentsMap.get(currCourse);
                    for (int course : depedentCoursesList) {
                        indegreeArray[course]--;
                        if (indegreeArray[course] == 0) {
                            queue.add(course);
                            totalCoursesDone++;
                        }
                    }
                }
            }

            return totalCoursesDone == numCourses;
        }
    }
}
