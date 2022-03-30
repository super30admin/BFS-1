import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(V+E); where V = numofcourses and E = length of prerequisites array
// Space Complexity : O(V+E)
public class CourseSchedule {
	/** Approach: Topological sort **/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	int[] indegrees= new int[numCourses];
		Map<Integer, List<Integer>> map= new HashMap<>();
		
		//prepare indegree array and adjacency list
		for(int[] course: prerequisites) {			
			indegrees[course[0]]++;
			if(!map.containsKey(course[1])) {
				map.put(course[1], new ArrayList<>());
			}			
			map.get(course[1]).add(course[0]); //independent node as key and dependency as list
		}
		
		//Process all independent nodes first and put them in queue
		Queue<Integer> q= new LinkedList<>();
		int count=0;
		for(int i=0; i<indegrees.length; i++) {
			if(indegrees[i]==0) {
				q.add(i);
				count++;
			}
		}
		
		//no independent course return false
        if(q.isEmpty()) return false;
		
		//Process other nodes until all courses are taken		
		while(!q.isEmpty()) {
			int curr= q.poll();			
			//reduce indegree of its babies
			List<Integer> children= map.get(curr);
			if(children == null) continue;
			for(int child: children) {
				indegrees[child]--;
				if(indegrees[child] == 0){//independent
					q.add(child);
					count++;					
					//if all courses are taken
					if(count == numCourses) return true;
				}
			}
		}
		
		if(count<numCourses) return false;
		return true;
    }

	// Driver code to test above 
    public static void main(String args[]) {
    	CourseSchedule ob = new CourseSchedule();
    	//int numCourses= 2;
    	//int[][] prerequisites= {{1,0}};
    	int numCourses= 6;
		int[][] prerequisites= {{1,0},{2,0},{1,6},{3,1},{3,2},{4,1},{5,2},{5,4}};
						
		System.out.println("Can you finish all courses ?: "+ob.canFinish(numCourses,prerequisites));		
    } 
}
