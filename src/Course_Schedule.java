//Time Complexity : O(V+E), For one vertex all edges are not processed , so V+E
//Space Complexity : O(V)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/* We built an adjacency list using a hashmap and have maintained the dependency of courses in an list 
 * Queue will be used for processing, add the course that is dependent in the array list so that we can use it while processing the courses in queue
 * Get the courses that are dependent, with those children,we will be going to the array and decreasing the dependency
 * in the end all classes must have been visited to return true, else return false*/


import java.util.*;
public class Course_Schedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int indegree[] = new int[numCourses];   //to keep track of the no of dependencies a course(represented by index) has

		Map<Integer, List<Integer>> map = new HashMap<>();  // to store depended course on course

		for(int edge[]: prerequisites){
			indegree[edge[0]]++;    // for first index increment its indegree as it is dependent
			if(!map.containsKey(edge[1]))   // put the subject it is dependent on as key
				map.put(edge[1], new ArrayList<>());

			map.get(edge[1]).add(edge[0]);  // add the course that is dependent in the array list so that we can use it while processing the courses in queue
		}

		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<indegree.length; i++){
			if(indegree[i] == 0)    // finding all the courses that are independent
				q.add(i);
		}

		while(!q.isEmpty()) {
			int curr = q.poll();    // remove from queue
			List<Integer> child = map.get(curr);    // get the courses dependent on curr
			if(child != null){
				for(int i: child){
					indegree[i]--;  // reducing indegree as the course they are dependent on has been completed

					if(indegree[i] == 0)    // if the value becomes zero i.e it is independent
						q.add(i);
				}
			}
		}

		for(int i: indegree) {   // check if at any course, the indegree is greater than 0
			if(i > 0)
				return false;
		}
		return true;
	}
}
