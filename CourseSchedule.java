// Time Complexity : O(v+e)
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : prerequisites) {
            inDegrees[edge[0]]++;

            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }

        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegrees[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        if (queue.isEmpty())
            return false;

        while (!queue.isEmpty() && count < numCourses) {
            int cur = queue.poll();
            //  course completed
            //  reduce dependency of courses dependant on this course
            List<Integer> children = map.get(cur);
            if (children != null) {
                for (int child : children) {
                    inDegrees[child]--;

                    if (inDegrees[child] == 0) {
                        queue.add(child);
                        count++;
                    }
                }
            }
        }

        return count == numCourses;
    }
}
