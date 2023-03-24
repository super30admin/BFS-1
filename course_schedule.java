import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

// Did this code run on leetcode successfully? : Yes
class Solution {
    // Time Complexity: O(n); n = number of courses
    // Space Complexity: O(n)
    private boolean isCycle(int course, Map<Integer, List<Integer>> graph, Set<Integer> gray, Set<Integer> black) {
        // Mark processing
        gray.add(course);

        List<Integer> neighbors = graph.get(course);
        if(neighbors != null) {
            for(int neighbor : neighbors) {
                // Already processed, hence ignore
                if(black.contains(neighbor)) {
                    continue;
                }

                // If currently procssing, means we saw this again
                // or if cycle exists from this neighbor
                if(gray.contains(neighbor) || isCycle(neighbor, graph, gray, black)) {
                    return true;
                }
            }
        }

        // Remove processing
        gray.remove(course);

        // Mark processed
        black.add(course);

        return false;
    }

    // Time Complexity: O(n^2); n = number of courses
    // Space Complexity: O(n)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses <= 0) {
            return false;
        }

        // Create the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] prerequisite: prerequisites) {
            graph.putIfAbsent(prerequisite[0], new ArrayList<>());
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        Set<Integer> gray = new HashSet<>();
        Set<Integer> black = new HashSet<>();

        for(int course : graph.keySet()) {
            // If already processed, ignore
            if(black.contains(course)) {
                continue;
            }

            if(isCycle(course, graph, gray, black)) {
                return false;
            }
        }

        return true;
    }
}