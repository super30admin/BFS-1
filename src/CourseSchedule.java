// Time Complexity : o(V+E)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/course-schedule/
 * 
 *
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] inDegrees = new int[numCourses];
		Map<Integer, List<Integer>> courseChild = new HashMap<>();

		//calculate in degree for all the subjects
		for(int i=0; i<prerequisites.length;i++) {
			inDegrees[prerequisites[i][0]]++;

			//maintain map to keep track of all the dependents of the subject (list of dependents)
			if(!courseChild.containsKey(prerequisites[i][1])){
				courseChild.put(prerequisites[i][1], new ArrayList<>());   
			}    
			courseChild.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}

		Queue<Integer> q = new LinkedList<>();

		//get all subjects with indegree 0, they can be taken immediately
		for(int i=0; i<inDegrees.length; i++){
			if(inDegrees[i] == 0) {
				q.add(i);
			}
		}

		while(!q.isEmpty()){
			//take one subject from queue
			int currSub = q.poll();
			List<Integer> dependents = courseChild.get(currSub);

			//if it has dependents, reduce their in degree by 1 and if in degree becomes 0, then 
			//they can be taken so add them to the queue for processing
			if(dependents != null){
				for(int child:dependents){
					inDegrees[child]--;
					if(inDegrees[child] == 0) {
						q.add(child);
					}  
				}  
			}   
		}

		//add the end, if any subject remains with indegree > 0, it means that subject is not taken
		for(int num: inDegrees){
			if(num >0) {
				return false;
			}
		}

		return true;
	}
}
