package demo;
import java.util.LinkedList;
import java.util.Queue;

//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : Need to discuss ways to optimize it further. Reducing the need to iterate over prereq arrays again and again


//Your code here along with comments explaining your approach

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		//create an in degree array for all the dependent courses
		int[] degrees = new int [numCourses] ;

		Queue<Integer> queue = new LinkedList<>();
		//filling the in degree array as per the courses required
		for(int i=0; i< prerequisites.length; i++){
			// int temp = prerequisites[i][1];
			degrees[prerequisites[i][1]]++;

		}
		
		//processing the courses in the queue
		for(int i =0; i< degrees.length; i++){
			if(degrees[i]==0){
				queue.add(i);
			}
		}

		while(!queue.isEmpty()){
			int course = queue.poll();
			for(int i =0; i< prerequisites.length; i++){
				if(prerequisites[i][0] == course){
					degrees[prerequisites[i][1]]--;
					if(degrees[prerequisites[i][1]]==0){
						queue.add(prerequisites[i][1]);
					}
				}

			}
		}

		for(int i=0; i< degrees.length;i++){
			if(degrees[i] !=0){
				return false;
			}
		}
		return true;
	}
}

