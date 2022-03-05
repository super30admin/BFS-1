// TC : O(n+e) where n is no. of nodes and e is edges
// SC: O(e)

// Approach: Create an adjacency list and indegree array. Add the nodes with indegree as 
// 0 to the queue. Every time we complete a course, we pop that node from queue, check the
//  adjacency list and find the dependent courses. For those dependents, we reduce the indegree 
// value and update them to the queue if their indegree is 0. I

// LC- 207. Course Schedule

import java.util.*;

public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    int[] indegree = new int[numCourses];

    for (int[] prereq : prerequisites) {
      int dependent = prereq[0];
      int source = prereq[1];

      if (!adjList.containsKey(source)) {
        adjList.put(source, new ArrayList<>());
      }

      adjList.get(source).add(dependent);
      indegree[dependent]++;
    }

    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int completedCourses = 0;

    while (!q.isEmpty()) {
      int course = q.remove();
      completedCourses++;

      List<Integer> dependents = adjList.get(course);
      if (dependents != null) {
        for (int d : dependents) {
          indegree[d]--;

          if (indegree[d] == 0) {
            q.add(d);
          }
        }
      }
    }
    return numCourses == completedCourses;
  }
}
