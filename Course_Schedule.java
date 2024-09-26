import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Course_Schedule {
	//Approach: 1. I have built the adjacency list using a hashmap and have maintained the dependecy of courses in an array. 
	//2. For processing, will be using an queue, starting with independent courses, and getting thier corresponding dependent courses from the map. 
	//3. with those children, I will be going to the array and decreasing the dependency. This will continue till all the courses are processed and finally will check if all the dependencies are resolved.
	//4. If not will return false. 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        //indegrees to store the dependency
        int[] courses = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] edge: prerequisites)
        {
            //since edge[0] is dependent on edge[1], creating an dependency list 
            courses[edge[0]]++;
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
       /* for (Map.Entry mapElement : map.entrySet()) { 
            System.out.print(mapElement.getKey()+"--"+mapElement.getValue()); 
        }*/
        //starting with independent courses
        for(int i=0;i < courses.length;i++)
        {
         //   System.out.println("val at --"+i+"--"+courses[i]);
            if(courses[i] == 0)
                queue.add(i);
        }
        while(!queue.isEmpty())
        {
            
            int course = queue.poll();
         //   System.out.println(course);
            List<Integer> list = map.get(course);
            if(list != null)
            {
                for(int child:list)
                {
                    courses[child]--;
                    if(courses[child] == 0)
                        queue.add(child);
                }
            }
        }
        for(int i=0;i<courses.length;i++)
        {
          //  System.out.println("final at --"+i+"--"+courses[i]);
            if(courses[i] > 0)
                return false;
        }
        return true;
    }
}
//Time Complexity : O(v+e) 
//Space Complexity : O(v+e) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :