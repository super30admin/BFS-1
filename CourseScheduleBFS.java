// Time Complexity : O(E+V) where E is the number of edges and V is the number of vertices in the graph
// Space Complexity : o(E+V) where E is the number of edges and V is the number of vertices in the graph
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Topological sort using BFS
// We will be using a queue to perform a breadth first traversal of the graph.
// We will keep track of the indegree of each vertex and add all vertices with indegree 0 to the queue.
// We will then process each vertex in the queue and reduce the indegree of its neighbors by 1.
// If any neighbor's indegree becomes 0, we will add it to the queue.
// We will keep track of the number of vertices processed and at the end, if the count is equal to the number of courses, 
// it means we can finish all courses, otherwise we cannot.
import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegrees = new int[numCourses];

        Map<Integer, List<Integer>> map = new HashMap<>();

        // Build graph and indegree array
        for (int[] pr : prerequisites) {

            indegrees[pr[0]]++;

            map.putIfAbsent(pr[1], new ArrayList<>());

            map.get(pr[1]).add(pr[0]);
        }

        Queue<Integer> que = new LinkedList<>();

        // Add all courses with indegree 0
        for (int i = 0; i < numCourses; i++) {

            if (indegrees[i] == 0) {
                que.offer(i);
            }
        }

        int count = 0;

        while (!que.isEmpty()) {

            int curr = que.poll();

            count++;

            if (map.containsKey(curr)) {

                for (int dependent : map.get(curr)) {

                    indegrees[dependent]--;

                    if (indegrees[dependent] == 0) {
                        que.offer(dependent);
                    }
                }
            }
        }

        return count == numCourses;
    }
}