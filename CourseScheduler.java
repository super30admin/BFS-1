import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity : O(V+E)  , V=no. of vertices, E=no. of edges
// Space Complexity : O(V+E) , V=no. of vertices, E=no. of edges
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return true;

        int[] indegrees = new int[numCourses]; // indegrees array
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // adjacency list

        for (int[] req : prerequisites) {
            int in = req[0]; // filling the indegrees array and adjacency list
            int out = req[1];
            indegrees[in]++;
            if (!map.containsKey(out)) {
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }

        // BFS
        int completedCourses = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                completedCourses++;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if (edges == null)
                continue;
            for (int edge : edges) {
                indegrees[edge]--;
                if (indegrees[edge] == 0) {
                    q.add(edge);
                    completedCourses++;
                }
            }
        }

        return completedCourses == numCourses;

    }
}