import java.util.*;

public class CourseSchedule {
    // TC: O(M + N) where M is number of courses and N is the length of prerequisites
    // SC: O(M + N) where M is number of courses and N is the length of prerequisites
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int[] p : prerequisites) {
            int from = p[1];
            int to = p[0];
            adjacencyList.putIfAbsent(from, new ArrayList<>());
            adjacencyList.get(from).add(to);
            indegree[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int coursesCompleted = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                coursesCompleted++;
            }
        }
        if (coursesCompleted == numCourses) {
            return true;
        }
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            if (adjacencyList.containsKey(currCourse)) {
                for (int next : adjacencyList.get(currCourse)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.add(next);
                        coursesCompleted++;
                    }
                }
            }
        }
        return coursesCompleted == numCourses;
    }
}
