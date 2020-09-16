import java.util.*;

public class CourseSchedule {
	
	public boolean courseSchedule(int numCourses, int[][] prerequisites) {
		
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		int[] indegrees  = new int[numCourses];
		
		for(int[] edge: prerequisites) {
			int start = edge[1], end = edge[0];
			indegrees[end]++;
			if(!map.containsKey(start)) {
				
				map.put(start, new ArrayList());
			}
			map.get(start).add(end);
		}
		
		Queue<Integer> q = new LinkedList();
		int count = 0;
		
		for(int i=0;i<numCourses; i++) {
			if(indegrees[i]==0)
				q.offer(i);
		}
		
		while(!q.isEmpty()) {
			
			int course = q.poll();
			if(map.containsKey(course)) {
				for(int child: map.get(course)) {
					if(--indegrees[child]==0)
						q.offer(child);
				}
			}
			count++;
		}
		
		return numCourses==count;
	}
	
	public static void main(String[] args) {
		
		CourseSchedule cs = new CourseSchedule();
		int[][] prerequisites = {{1,0},{0,1}};
		System.out.println(cs.courseSchedule(2, prerequisites));
	}
	

}
