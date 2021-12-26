// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach BFS

// First got the indegrees for each vertices
// vertice with 0 indegrees is put into queue
// We make use of the map for adjacency list
// we pop the queue and add the dependent vertices if the their indegree is zero
// Atlast we check the total and courses and give out the answer

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return false;
        Queue<Integer> q = new LinkedList<>();
        int total = 0;
        HashMap<Integer, List<Integer>> map = new HashMap();
        int[] indegrees = new int[numCourses];
        for (int[] edge : prerequisites) {
            indegrees[edge[0]]++;
            if (!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList());
            map.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            total++;
            List<Integer> depCourses = map.get(curr);
            if (depCourses != null) {
                for (int edge : depCourses) {
                    indegrees[edge]--;
                    if (indegrees[edge] == 0)
                        q.add(edge);
                }
            }
        }
        return total == numCourses;
    }
}

// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach DFS

// Used a recursive approach
// We build the adjacency list
// take two arrays visted and path
// We check if the node has been visted or if there is cycle from that node, if
// yes we return false
// Has cycle is our recursive dfs function
class Solution {
    HashMap<Integer, List<Integer>> map;
    boolean[] visited;
    boolean[] path;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return false;
        int total = 0;
        map = new HashMap();
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        for (int[] edge : prerequisites) {
            if (!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList());
            map.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i))
                return false;
        }
        return true;
    }

    public boolean hasCycle(int i) {
        if (path[i])
            return true;
        if (visited[i])
            return false;
        visited[i] = true;
        path[i] = true;
        List<Integer> edges = map.get(i);
        if (edges != null) {
            for (int edge : edges)
                if (hasCycle(edge))
                    return true;
        }
        path[i] = false;
        return false;
    }
}