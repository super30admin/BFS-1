import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// TC : O (v + E)
// SC : O (v + E )
// where V is vertex and E is edges
public class Problem2 {
    boolean[] path;
    boolean[] visited;
    HashMap<Integer, List<Integer>> map;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        map = new HashMap<>();
        path = new boolean[numCourses];
        visited = new boolean[numCourses];

        for (int[] edge : prerequisites) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == false && hasCycle(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int course) {
        //base case
        if (path[course]) return true;
        if (visited[course]) return false;

        //logic
        path[course] = true;
        visited[course] = true;
        List<Integer> edges = map.get(course);
        if (edges != null) {
            for (int edge : edges) {
                if (hasCycle(edge)) return true;
            }
        }
        path[course] = false;
        return false;
    }
}
