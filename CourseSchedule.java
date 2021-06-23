// Time Complexity : O(V+E) // V is number of vertices and E is number of edges for vertices
// Space Complexity : O(V+E)  
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Prepare an array of incoming vertex count.
 * 2. prepare a hashmap of outbound vertex map for each vertex.
 * 3. choose vertices which has incoming as 0 count for first processing.
 * 4. for each node removing from queue update array node count.
 * 5. if vertex count is zero process it.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indArr=new int[numCourses];
		Map<Integer, List<Integer>> outdegreeMap= new HashMap<>();
		
		for (int[] is : prerequisites) {
			int out=is[0];
			int in=is[1];
			indArr[out]++;
			outdegreeMap.computeIfAbsent(in, k-> new ArrayList<Integer>()).add(out);
		}

		Queue<Integer> queue=new LinkedList<>();
		for (int i=0;i<indArr.length;i++) {
			if(indArr[i]==0) {
				queue.add(i);
			}
		}
		
		if(queue.size()==0)	return false;
		int count=0;
		while(!queue.isEmpty()) {
			int ele=queue.poll();
			count++;
			List<Integer> outlist=outdegreeMap.get(ele);
			if(outlist!=null) {
				for (Integer out : outlist) {
					indArr[out]--;
					if(indArr[out]==0)
						queue.add(out);
				}
			}
		}
		
		if(count == numCourses) return true;
		return false;
	}
	
	public static void main(String[] args) {
		int[][] arr = new int[1][];
		arr[0]= new int[] {0,1};
		System.out.println(new CourseSchedule().canFinish(2, arr));
	}
}
