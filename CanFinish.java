import java.util.Arrays;
import java.util.Queue;

/**
 * @author Vishal Puri
 * // Time Complexity : O(v+e)
 * // Space Complexity : O(v+e)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] edges) {
        if (edges == null || edges.length == 0)
            return true;
        int indeg[] = new int[numCourses];
        Arrays.fill(indeg, 0);
        Queue<Integer> q = (Queue<Integer>) new LinkedList();
        int e = edges.length;
        for (int i = 0; i < e; i++) {
            if (edges[i][0] == edges[i][1])
                return false;
            indeg[edges[i][1]]++;
        }
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int top = q.peek();
            System.out.println(top);
            q.remove();
            count++;
            for (int i = 0; i < e; i++) {

                if (edges[i][0] == top) {
                    indeg[edges[i][1]]--;
                    if (indeg[edges[i][1]] == 0)
                        q.add(edges[i][1]);
                }
            }
        }

        return count >= numCourses - 1 ? true : false;
    }
}

