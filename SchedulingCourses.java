// Time complexity: O(v + e)
// Space complexity: O(v + e)
// Approach: Have an indegree data structure, dependencies and a queue. Start by adding 
// courses with 0 dependencies to the queue. Process them, if more courses free up; add them to
// the queue

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SchedulingCourses {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> dependenciesFrequency = new HashMap();
        Map<Integer, ArrayList<Integer>> edges = new HashMap();

        Queue<Integer> queue = new LinkedList();

        for (int i = 0; i < prerequisites.length; i++) {
            int val = dependenciesFrequency.getOrDefault(prerequisites[i][0], 0);
            // building indegrees
            dependenciesFrequency.put(prerequisites[i][0], ++val);
            if (!edges.containsKey(prerequisites[i][1])) {
                edges.put(prerequisites[i][1], new ArrayList());
            }
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dependenciesFrequency.containsKey(i)) {
                // courses with no prerequisites
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int current = queue.poll();
            // no other course depends on this course
            if (!edges.containsKey(current))
                continue;

            for (int i = 0; i < edges.get(current).size(); i++) {
                int dependency = edges.get(current).get(i);
                int indegree = dependenciesFrequency.get(dependency);
                dependenciesFrequency.put(dependency, --indegree);
                if (indegree == 0) {
                    queue.add(dependency);
                }
            }
        }
        return count == numCourses;
    }
}