/**
 * Time Complexity (TC): O(V + E)
 * Space Complexity (SC): O(V + E)
 * where V is the number of courses and E is the number of prerequisites.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> coursePrerequisite = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            coursePrerequisite.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            coursePrerequisite.get(prereq[1]).add(prereq[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, coursePrerequisite, visited, stack)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int current, List<List<Integer>> coursePre, boolean[] visited, boolean[] stack) {
        if (stack[current]) {
            return true;
        }

        if (visited[current]) {
            return false;
        }

        visited[current] = true;
        stack[current] = true;

        for (int edge : coursePre.get(current)) {
            if (hasCycle(edge, coursePre, visited, stack)) {
                return true;
            }
        }

        stack[current] = false;

        return false;
    }
}
