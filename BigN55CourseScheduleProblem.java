// Time complexity is O(V*E) as we are processing edges for each vertices
// Space complexity is O(V+E) i.e for hashmap and indegree array
// this solution is submitted on leetcode
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BigN55CourseScheduleProblem {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < prerequisites.length; i++) {
			indegree[prerequisites[i][0]]++;
			if (!map.containsKey(prerequisites[i][1])) {
				map.put(prerequisites[i][1], new ArrayList<Integer>());
			}
			map.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}
		while (!q.isEmpty()) {
			int course = q.poll();
			List<Integer> courseList = map.get(course);
			if (courseList != null) {
				for (int courses : courseList) {
					indegree[courses]--;
					if (indegree[courses] == 0)
						q.offer(courses);
				}
			}
		}
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] > 0)
				return false;
		}
		return true;
	}
}