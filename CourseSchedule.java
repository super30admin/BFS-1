/*The time complexity of this implementation is O(V+E) and space complexity is O(V)
where V is vertices and E is edges
 * */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        // Count incoming edges for each node
        int[] inDegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            inDegree[prereq[0]]++;
        }

        // Create a queue to store nodes with zero incoming edges
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Visit each node in the graph using BFS
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0}, {2,1}, {3,2}, {1,3}};
        CourseSchedule solution = new CourseSchedule();
        boolean canTakeCourses = solution.canFinish(numCourses, prerequisites);
        if (canTakeCourses) {
            System.out.println("All courses can be taken.");
        } else {
            System.out.println("There is a cycle in the graph and some courses cannot be taken.");
        }
    }

}
