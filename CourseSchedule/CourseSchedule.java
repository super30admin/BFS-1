import java.util.LinkedList;
import java.util.Queue;

//Time Complexity - O(n*m)
// n - Number of Courses
// m - Number of Pre-requiste courses
//Space Complexity - O(n)

class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegrees = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			indegrees[prerequisites[i][0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegrees.length; i++) {
			if (indegrees[i] == 0) {
				queue.add(i);
			}
		}

		int count = 0;

		while (!queue.isEmpty()) {

			int courseNumber = queue.remove();
			count++;
			for (int i = 0; i < prerequisites.length; i++) {
				if (courseNumber == prerequisites[i][1]) {
					indegrees[prerequisites[i][0]]--;

					if (indegrees[prerequisites[i][0]] == 0)
						queue.add(prerequisites[i][0]);

				}
			}
		}

		if (count == numCourses)
			return true;
		else
			return false;
	}
}