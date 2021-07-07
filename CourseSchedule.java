/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * 
 * This graph can be formulated as directed acyclic graph and hence the idea is
 * to use topological ordering. This reduces to finding a topological ordering,
 * if one exists, it implies the schedule can be done, otherwise, it is not
 * possible to complete it.
 * 
 * V is numCourse, E is the edges 
 * Space Complexity: O(V+E) 
 * Time Complexity: O(V+E)
 * 
 * Leetcode Attempts: 3
 * 
 * Leetcode Result: Runtime: 5 ms, faster than 69.28% of Java online submissions
 * for Course Schedule. Memory Usage: 44.2 MB, less than 96.15% of Java online
 * submissions for Course Schedule.
 * 
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // base case checks
        if (numCourses < 2) {
            return true;
        }
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        // init empty graph
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }
        // create graph and compute indegree array
        for (int[] prereq : prerequisites) {
            List<Integer> courses = graph.get(prereq[1]);
            courses.add(prereq[0]);
            indegree[prereq[0]]++;
        }
        // create queue of courses with indegrees 0, the ones that have no prereqs.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        // if no such starting point exists.
        if (queue.size() == 0) {
            return false;
        }
        // we want to generate a topological ordering
        int topNum = numCourses;
        while (queue.size() > 0) {
            int course = queue.remove();
            topNum--;
            List<Integer> courses = graph.get(course);
            for (int c : courses) {
                // we are taking course c, so reduce indegree of edge c to corresponding course
                indegree[c]--;
                if (indegree[c] == 0) {
                    queue.add(c);
                }
            }
        }
        // if a topo order consisting of all nodes has been generated, topNum should be
        // 0.
        return topNum == 0;
    }
}