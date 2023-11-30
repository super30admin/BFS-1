
// Time complexity : O(V+E)
// Space complexity : O(V+E)
import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = { { 1, 0 }, { 4, 1 }, { 3, 2 }, { 3, 1 }, { 2, 0 }, { 5, 4 }, { 5, 2 } };
        boolean result = canFinish(numCourses, prerequisites);
        System.out.println(result);
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegrees[pre[0]]++;
            if (!map.containsKey(pre[1])) {
                map.put(pre[1], new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> children = map.get(curr);
            if (children != null) {
                for (int child : children) {
                    indegrees[child]--;
                    if (indegrees[child] == 0) {
                        queue.add(child);
                        count++;
                    }
                    if (count == numCourses)
                        return true;
                }
            }
        }
        return false;
    }

}
