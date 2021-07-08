import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {

    /*
    TC : O(E + V^2) where E is the edges or the dependencies and V is the vertices that is the number of courses\
    SC : O(E+V)
    LC : Yes
    Problems : No
     */
    /**
     * Here we use the topological sort algorithm and perform DFS on the graph basically to check whether a cycle is present in the graph
     * Because that means there is cyclic dependency and the courses cannot be finised
     */
    HashMap<Integer, List<Integer>> map;
    boolean[] visited;
    boolean[] path;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            if (!map.containsKey(prerequisite[1])) {
                map.put(prerequisite[1], new ArrayList<>());
            }

            map.get(prerequisite[1]).add(prerequisite[0]);
        }


        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i)) {
                return false;
            }
        }

        return true;
    }


    private boolean hasCycle(int i) {

        if (path[i]) return true;

        //base case
        if (visited[i]) return false;


        visited[i] = true;

        path[i] = true;

        List<Integer> children = map.get(i);
        if (children != null) {
            for (int child : children) {

                if (hasCycle(child))
                    return true;
            }
        }

        //backtrack
        path[i] = false;
        return false;
    }
}
