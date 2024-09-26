//Time Complexity: O(n) 
//Space Complexity: hasNext: O(n) n is number of courses

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int [] degrees = new int [numCourses];
        // creating a map of course as key and its pre req as value and incrementing the pre req index in the array
        for(int i=0; i<prerequisites.length; i++){
            if(!map.containsKey(prerequisites[i][0]))
                map.put(prerequisites[i][0], new ArrayList<Integer>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            degrees[prerequisites[i][1]]++;
        }
        System.out.println(map);
        
        //Adding value with 0 as our start node
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i < degrees.length; i++){
            if(degrees[i] == 0){
                q.add(i);
            }
        }         

        //iterating until queeue is empty. Popping the queue elements and decrementing it count in the degrees array
        while(!q.isEmpty()){
            int course = q.poll();
            List <Integer> children = map.get(course);
            if(children != null){
                for(Integer child : children){
                    degrees[child]--; 
                    if(degrees[child] == 0){
                        q.add(child);
                    }
                }
            }
        }  

        //Check if there are any value other than 0
        Arrays.sort(degrees);
        if(degrees[degrees.length-1] != 0)
            return false;
        return true;
    }
}