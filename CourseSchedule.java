package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time: O(numCourses * prerequisites)
 * Space: O(numCourses)
 * Leetcode accepted: yes
 * Problems faced: NA
 */
public class CourseSchedule {

	public static void main(String[] args) {
		int[][] prerequisites = {{1,0}, {2, 1}};
		System.out.println(canFinish(3, prerequisites));
	}
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
	   int coursesTaken = 0;
	   
	   //Store the count of pre-requisites for each course in a helper array (index as courseNum)
       int[] numPrereqs = new int[numCourses];
       for(int i=0; i<numCourses; i++) {
    	   		for(int j=0; j<prerequisites.length; j++) {
    	   			if(prerequisites[j][0] == i) {
    	   				numPrereqs[i]++;
    	   			}
    	   		}
       }
	//Add all the courses that do not have pre-reqs to a queue	
      Queue<Integer> q = new LinkedList<>();
      for(int i=0; i<numPrereqs.length; i++) {
    	  	if(numPrereqs[i] == 0) {
    	  		q.add(i);
    	  	}
      }
      
      //Keep popping the each course from queue to complete it and reduce the corresponding count value
      //in the helper array
      while(!q.isEmpty()) {
	    	  int currCourse = q.remove();
	    	  coursesTaken++;
	    	  for(int j=0; j<prerequisites.length; j++) {
	    		if(prerequisites[j][1] == currCourse) {
	    			numPrereqs[prerequisites[j][0]]--;
	    			if(numPrereqs[prerequisites[j][0]] == 0) {
	    				q.add(prerequisites[j][0]);
	    			}
	    		}
	    	  }
      }
      return coursesTaken == numCourses;
    }

}
