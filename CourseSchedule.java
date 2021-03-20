// Time Complexity : O(|E| + |V|), where E is the number of edges in the given graph and V is the number of vertex
// Space Complexity : O(|E| + |V|)

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> topologicalOrder = new ArrayList<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][0], course = prerequisites[i][1];
            graph.get(pre).add(course);
            inDegree.put(course, inDegree.get(course) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.offer(entry.getKey());
            }
        }

        while (!sources.isEmpty()) {
            int course = sources.poll();
            topologicalOrder.add(course);
            List<Integer> preReq = graph.get(course);
            for (int p : preReq) {
                inDegree.put(p, inDegree.get(p) - 1);
                if (inDegree.get(p) == 0) {
                    sources.add(p);
                }
            }
        }

        if (topologicalOrder.size() == numCourses) {
            return true;
        }
        return false;
    }
}
