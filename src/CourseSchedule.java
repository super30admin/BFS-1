import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

/**
 * This is topological sorting. We will check for cycles by calculating indegrees of each graph nodes.
 * If indegree is not 0 for any node, then there is a cycle in the graph. So we have to maintain indegree 
 * and out going nodes for each course using graph. Put each course along with its graph node in a map for easy
 * fetching. Iterate over each prerequiste and update respective indegrees and out going nodes. Then iterate over
 * the map to see if any indegree is 0 for a node and add it to the queue. Now, while queue is not empty, pop the course
 * and fetch its out going nodes and reduce indegree for each of them and push them to queue if any of the nodes have
 * indegree as 0. Once queue is empty, check if the checked courses are equal to prerequiste length.
 *
 */
class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites.length == 0)
			return true;
		Map<Integer, GraphNode> map = new HashMap<>();
		for (int[] pre : prerequisites) {
			GraphNode prev = getNode(pre[1], map);
			GraphNode curr = getNode(pre[0], map);

			prev.nodes.add(pre[0]);
			curr.inDegree++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (Map.Entry<Integer, GraphNode> entry : map.entrySet()) {
			if (entry.getValue().inDegree == 0)
				queue.add(entry.getKey());
		}

		int checkedCourses = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			List<Integer> nodes = map.get(course).nodes;
			for (int nextCourse : nodes) {
				GraphNode next = map.get(nextCourse);
				next.inDegree--;
				checkedCourses++;
				if (next.inDegree == 0)
					queue.add(nextCourse);
			}
		}

		return checkedCourses == prerequisites.length;
	}

	public GraphNode getNode(int course, Map<Integer, GraphNode> map) {
		GraphNode node = null;
		if (map.containsKey(course))
			return map.get(course);
		node = new GraphNode();
		map.put(course, node);
		return node;
	}
}

class GraphNode {
	public int inDegree = 0;
	public List<Integer> nodes = new LinkedList<>();
}
