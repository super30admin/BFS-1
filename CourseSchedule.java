// Time Complexity : O(v+e) [e: Edges {(0, 3)}, v: Vertexes {numCourses}]
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] inDegrees = new int[numCourses];

        for (int[] edge : prerequisites) {
            int in = edge[0];
            int out = edge[1];

            inDegrees[in]++;

            if (!map.containsKey(out)) {
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }

        Queue<Integer> queue = new LinkedList<>();

        int cnt = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
                cnt++;
            }
        }

        if (queue.isEmpty()) {
            return false;
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> children = map.get(curr);
            if (children == null) {
                continue;
            }

            for (int child : children) {
                inDegrees[child]--;
                if (inDegrees[child] == 0) {
                    queue.offer(child);
                    cnt++;
                }
                if (cnt == numCourses) {
                    return true;
                }
            }
        }
        if (cnt == numCourses) {
            return true;
        }
        return false;
    }
}