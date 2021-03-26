import java.util.*;
// Time Complexity : O(V + E); v = numCourses; e: edges in graph; Worst case: O(n^2): n = numcourses
// Space Complexity : Asymptotic O(V + E); Bcz in hashmap we are storeing all numcourses(V) and edges; for array & queue: O(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] x : prerequisites) {
            int from = x[1];
            int to = x[0];

            inDegree[to]++;
            if (!map.containsKey(from))
                map.put(from, new ArrayList<>());
            map.get(from).add(to);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int front = queue.poll();

            if (map.containsKey(front)) {
                for (int i : map.get(front)) {
                    inDegree[i]--;
                    if (inDegree[i] == 0)
                        queue.add(i);
                }
            }
        }

        for (int i : inDegree) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
