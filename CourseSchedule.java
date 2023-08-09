// Time Complexity : O(m + n) where m is the number of courses and n is the number of prerequisites
// Space Complexity : O(m + n) where m is the number of courses and n is the number of prerequisites
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the directed graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Fill the adjacency list with prerequisites
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        // Create an array to track visited nodes
        boolean[] visited = new boolean[numCourses];
        // Create an array to track recursion stack (for cycle detection)
        boolean[] recursionStack = new boolean[numCourses];

        // Perform DFS on each node to check for cycles
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(graph, i, visited, recursionStack)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int node, boolean[] visited, boolean[] recursionStack) {
        visited[node] = true;
        recursionStack[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(graph, neighbor, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack[neighbor]) {
                return true;
            }
        }

        recursionStack[node] = false;
        return false;
    }
}