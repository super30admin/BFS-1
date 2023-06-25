// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        for (int[] pr : prerequisites) {
            inDegrees[pr[0]]++;
            if (!map.containsKey(pr[1])) {
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> li = map.get(curr);
            if (li != null) {
                for (int child : li) {
                    inDegrees[child]--;
                    if (inDegrees[child] == 0) {
                        q.add(child);
                        count++;
                        if (count == numCourses)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}