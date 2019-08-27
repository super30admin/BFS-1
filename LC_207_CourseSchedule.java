// Time Complexity :O(numCourses * prerequisitesArray)/
// Space Complexity :O(numCourses)// Declaring new Array List to store the necessary prereq's for each course
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No, as already discussed in class
import java.util.*;
import java.io.*;
public class LC_207_CourseSchedule {
	  public static boolean canFinish(int numCourses, int[][] prerequisites) {
	        int[] courses= new int[numCourses];
	        //Add the number of prerequisites needed for each course
	        for(int i=0; i<prerequisites.length; i++ ){
	            courses[prerequisites[i][0]]++;
	        }
	        Queue<Integer> queue= new LinkedList<Integer>();
	        //This variable keeps track of how many courses can be completed 
	        int count=0;
	        //Traverse the array and add the course which requires no prerequisites
	        for(int i=0;i<courses.length;i++){
	            if(courses[i]==0)
	                queue.add(i);
	        }
	        
	        while(!queue.isEmpty()){
	            int val= queue.poll();
	            count++;
	            // Traverse through the prereq array and decrement the value for courses which had polled val was                   prereq
	            //Once done check courses array again for 0 prereq and add to the queue
	            for(int i=0;i<prerequisites.length;i++){
	                if(prerequisites[i][1]==val){
	                    courses[prerequisites[i][0]]--;
	                    if(courses[prerequisites[i][0]]==0){
	                        queue.add(prerequisites[i][0]);
	                    }
	                }
	            }
	  
	        }
	        if(count == numCourses ) return true;
	        else return false;
	  
	    }
	  public static void main(String[] args) {
		  int[][] input = {{1,0}};
		  int numCourses=2;
		  
		  System.out.print("Can finish the course schedule?: "+canFinish(numCourses, input));
		  
	  }

}
