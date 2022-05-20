import java.util.*;

class CourseSchedule {

  // Time Complexity : O(V+E), V- Counrses, E-Prerequisites
  // Space Complexity : O(V+E)
  // Did this code successfully run on Leetcode :

  public static boolean isSchedulingPossible(int numCourses, int[][] prerequisites) {
    List<Integer> sortedOrder = new ArrayList<>();
    if (numCourses <= 0)
      return false;

    // a. Initialize the graph
    HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
    HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
    for (int i = 0; i < numCourses; i++) {
      inDegree.put(i, 0);
      graph.put(i, new ArrayList<Integer>());
    }

    // b. Build the graph
    for (int i = 0; i < prerequisites.length; i++) {
      int parent = prerequisites[i][0], child = prerequisites[i][1];
      graph.get(parent).add(child); // put the child into it's parent's list
      inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
    }

    // c. Find all sources i.e., all vertices with 0 in-degrees
    Queue<Integer> sources = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0)
        sources.add(entry.getKey());
    }

    // d. For each source, add it to the sortedOrder and subtract one from all of
    // its children's in-degrees
    // if a child's in-degree becomes zero, add it to the sources queue
    while (!sources.isEmpty()) {
      int vertex = sources.poll();
      sortedOrder.add(vertex);
      List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
      for (int child : children) {
        inDegree.put(child, inDegree.get(child) - 1);
        if (inDegree.get(child) == 0)
          sources.add(child);
      }
    }

    // if sortedOrder doesn't contain all numCourses, there is a cyclic dependency
    // between numCourses, therefore, we
    // will not be able to schedule all numCourses
    return sortedOrder.size() == numCourses;
  }

  public static void main(String[] args) {

    boolean result = CourseSchedule.isSchedulingPossible(2, new int[][] { new int[] { 1, 0 } });
    System.out.println("numCourses execution possible: " + result);

    result = CourseSchedule.isSchedulingPossible(2,
        new int[][] { new int[] { 1, 0 }, new int[] { 0, 1 } });
    System.out.println("numCourses execution possible: " + result);

  }
}