// Time Complexity : V+E
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Approach
// Traverse through prerequisites and maintain a hashmap with courses as keys and their prequisistes as their values and list with total number of prerequisites for each course
//Initiate a queue and add less dependent value into it
//pop each course and reduce the number of prerequisites for that particular course in inDegrees list
//If the inDegrees list is empty, then return true or false
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: prerequisites){
            inDegrees[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegrees.length;i++){
            if(inDegrees[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child: children){
                    inDegrees[child]--;
                    if(inDegrees[child] == 0){
                        q.add(child);
                    }
                }
            }
        }
        for(int i=0; i<inDegrees.length;i++){
            if(inDegrees[i] > 0){
                return false;
            }
        }
        return true;
    }
}
