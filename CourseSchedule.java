// Time Complexity :O(Vertex + Edges)
// Space Complexity :O(Vertes + Edges)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Approach was not intuitive to me

// Your code here along with comments explaining your approach
//1. Keep track of the number of courses that need a prerequisite to be completed in an array.
//2. Also consider a HashMap that would contain the list or courses and it's prerequisites.
//3. Use topological sort to count the no of courses and compare it with the given numCourses.


import java.util.*;
class CourseSchedule{

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        //Degrees array
        for(int[] edge: prerequisites){
            int start = edge[1];
            int end = edge[0];
            degrees[end]++;
            if(!map.containsKey(start)){
                map.put(start, new ArrayList<>());
            }
            map.get(start).add(end);
        }
        
        //topological sort
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        for(int i = 0; i < numCourses; i++) 
            if(degrees[i] == 0) q.add(i);
        
        while(!q.isEmpty()){
            int course = q.remove();
            if(map.containsKey(course)){
                for(int list: map.get(course)){
                    if(--degrees[list] == 0){
                        q.add(list);
                    }
                }
                
            }
            count++;
            
        }
        
        return count == numCourses;
        
        
    }
    public static void main(String args[]){
       CourseSchedule obj = new CourseSchedule();
       int numCourses = 6;
       int[][] prerequisites ={{2,0},{4,0},{1,2},{1,4},{3,2},{5,3}};
     System.out.println(obj.canFinish(numCourses, prerequisites)) ;

    }
}