import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Time COmplexity -> O(V+E) Best Case
O(V*E) Worst Case
Space COmpleity -> O(V+E)

*/



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return false;
        }
        int[] adjList = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int[] prereq : prerequisites) {
            int to = prereq[0];
            int from = prereq[1];
            adjList[to]++;
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }
        for (int i = 0; i < numCourses; i++) {
            if (adjList[i] == 0) {
                q.add(i);
                count++;
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if (edges == null) {
                continue;
            }
            for (int i = 0; i < edges.size(); i++) {
                adjList[edges.get(i)]--;
                if (adjList[edges.get(i)] == 0) {
                    q.add(edges.get(i));
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}