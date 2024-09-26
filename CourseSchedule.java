// Time Complexity : O(N) N number of nodes
// Space Complexity : O(N) N number of nodes
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Here we need to identify if two or more courses have cyclic dependency, there can't be a valid course schedule.
// To identify whether a valid schedule exists, we first need to add the courses that are not dependent on any other course.
// Once these courses are added to the schedule, we can add the courses that have dependency if their dependency has been resolved.
// To identify a course is dependent or not we can maintain indegree array, that keeps a count of courses, a course X is
// dependent on. We can keep a queue where we keep adding courses whose indegree value becomes 0, that means that course is not dependent on any other
// course to be completed. At the end, if the dependencies(indegree values) for courses become 0, that means it is valid schedule.

import java.util.*;
import java.util.LinkedList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] indegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            int dependent = prereq[0];
            int pre = prereq[1];
            indegree[dependent]++;
            if (!map.containsKey(pre)) {
                map.put(pre, new ArrayList<>());
            }
            map.get(pre).add(dependent);
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            List<Integer> dependents = map.get(current);
            if (dependents == null) continue;

            for (int dependent : dependents) {
                indegree[dependent]--;
                if (indegree[dependent] == 0) {
                    queue.add(dependent);
                }
            }

        }


        for (int val : indegree) {
            if (val > 0) return false;
        }

        return true;
    }

}
