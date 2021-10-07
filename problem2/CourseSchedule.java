//Time Complexity : O(|V| + |E|), V -> Number of courses, E -> Number of dependencies (edges)
// Space Complexity : O(|V| + |E|)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
	int[] inDegrees;
	Map<Integer, List<Integer>> adjacencyList;

	public void getAdjacencyList(int numCourses, int[][] prerequisites) {
		for (int i = 0; i < prerequisites.length; i++) {
			if (adjacencyList.containsKey(prerequisites[i][1])) {
				adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);
			} else {
				List<Integer> adjacentNodes = new ArrayList<Integer>();
				adjacentNodes.add(prerequisites[i][0]);
				adjacencyList.put(prerequisites[i][1], adjacentNodes);
			}
			inDegrees[prerequisites[i][0]]++;
		}
	}

	/*
	 * Use topological sort to check if the given set of courses form a DAG. Start
	 * with courses which have no incoming edges, by adding them to a queue. Process
	 * each node from the queue. While processing, reduce the indegrees of all its
	 * adjacent nodes by 1. If the indegree of any adjacent node becomes 0, all its
	 * prerequisites have been completed. It can now be processed too. Add it to the
	 * queue. If all courses have been processed, then all the courses can be
	 * completed.
	 */
	public boolean topologicalSort(int numCourses) {

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < numCourses; i++) {
			if (inDegrees[i] == 0) {
				queue.add(i);
			}
		}

		int visitedCnt = 0;

		while (!queue.isEmpty()) {
			int course = queue.poll();
			if (adjacencyList.containsKey(course)) {
				for (Integer adj : adjacencyList.get(course)) {
					if (--inDegrees[adj] == 0) {
						queue.add(adj);
					}
				}
			}
			visitedCnt++;
		}

		return visitedCnt == numCourses;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0) {
			return true;
		}

		inDegrees = new int[numCourses];
		adjacencyList = new HashMap<Integer, List<Integer>>();

		getAdjacencyList(numCourses, prerequisites);

		return topologicalSort(numCourses);
	}

	public static void main(String[] args) {
		CourseSchedule obj = new CourseSchedule();
		int numCourses = 2;
		int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
		System.out.println("Can we finish all courses? " + (obj.canFinish(numCourses, prerequisites) ? "Yes" : "No"));
	}

}
