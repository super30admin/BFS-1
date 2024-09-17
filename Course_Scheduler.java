
// Time Complexity : O(V + E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Course_Scheduler {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int indegrees[] = new int[numCourses];
		HashMap<Integer, List<Integer>> hmap = new HashMap<>();
		for (int edge[] : prerequisites) {
			indegrees[edge[0]]++;
			if (!hmap.containsKey(edge[1])) {
				hmap.put(edge[1], new ArrayList<>());
			}
			hmap.get(edge[1]).add(edge[0]);
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < indegrees.length; i++) {
			if (indegrees[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int curr = q.poll();
			List<Integer> list = hmap.get(curr);
			if (list != null) {
				for (int i : list) {
					indegrees[i]--;
					if (indegrees[i] == 0) {
						q.add(i);
					}
				}
			}
		}
		for (int i = 0; i < indegrees.length; i++) {
			if (indegrees[i] > 0) {
				return false;
			}
		}
		return true;
	}
}