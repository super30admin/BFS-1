// Time Complexity  - 
// Space Complexity - 
// Did this code successfully run on Leetcode : Yes successfully ran
// Any problem you faced while coding this : No
					  
*/	


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

	private boolean canFinish(int numCourses, int[][] prerequisites) {

		int[] NoOfDependencies = new int[numCourses];
		HashMap<Integer, List<Integer>> dependentElements = new HashMap<>();

		for (int i = 0; i < prerequisites.length; i++) {
//			int dependencies = prerequisites[i][0];
//			int num = NoOfDependencies[dependencies];
//			NoOfDependencies[dependencies] = num++;
			
			
			NoOfDependencies[prerequisites[i][0]]++;
			if (!dependentElements.containsKey(prerequisites[i][1])) {
				dependentElements.put(prerequisites[i][1], new ArrayList<>());

			}
			dependentElements.get(prerequisites[i][1]).add(prerequisites[i][0]);

		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i< NoOfDependencies.length; i++) {
			if(NoOfDependencies[i] ==0) {
				q.add(i);
			}
		}
		
		if(q.isEmpty()) return false;
		
		while(!q.isEmpty()) {
			int course = q.poll();
			List<Integer> list = dependentElements.get(course);
			
			if(list!=null) {
				for(int l: list) {
					NoOfDependencies[l]--;
					if(NoOfDependencies[l] == 0) {
						q.add(l);
					}
				}
			}
		}
		
		for(int i=0; i<NoOfDependencies.length; i++ ) {
			if(NoOfDependencies[i] > 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		int numCourses = 6;
		int[][] prerequisites = { { 2, 0 }, { 4, 0 }, { 1, 2 }, { 0, 5 }, { 3, 2 }, { 5, 1 }, { 5, 3 } };

		CourseSchedule c = new CourseSchedule();
		boolean res = c.canFinish(numCourses, prerequisites);
		System.out.println(res);
	}

}
