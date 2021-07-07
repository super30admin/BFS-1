// Time Complexity : O(n) , n is number of courses
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //prerequisite[course][prereq for the course]
        
        //create an array to know number of prereq to complete for the course
        int[] indegrees  = new int[numCourses];
        //hasmap to store (course, outedge from the course(list of course that its prereq for))
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //queue to add courses which are completed/can complete(when no prereq pending)
        Queue<Integer> q = new LinkedList<>();
         //to add values to indegrees and map
        for(int i = 0; i < prerequisites.length; i++) {
            // we have to count the number of times courses are in array[i][0] position
            //increase the count for everytime the course has a prereq to do
            indegrees[prerequisites[i][0]]++;
            //if the prereq is not present in map,
            if(!map.containsKey(prerequisites[i][1])) {
                //add the prerequisite to the map as key
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            //add values to key, 
            //for each [i][1] add [i][0] (the outdeg from the key(course))
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);            
        }
        //add courses to queue whose indegree is 0 (no prereq to do for the course)
        for(int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0) {
                q.add(i);
            }
        }
        
        //while q is not empty
        while(!q.isEmpty()) {
            //remove the front of queue
            int curr = q.poll();
            //get the outdeg from the map(the courses which have this course has prereq) 
            //(to decrease count in indegree array)
            List<Integer> outdegrees = map.get(curr);
            //if the course is prereq to some courses
            //(null = if course is not a prereq to any other course)
            if(outdegrees != null) {
                //get the list of outdegree
                //iterate through it
                for(int out : outdegrees) {
                //System.out.println(out);
                //decrease indegree count for that course 
                   indegrees[out]--; 
                //check if indegree count for that course is 0
                   if(indegrees[out] == 0) {
                       //if 0, add that course (number) to queue
                   q.add(out);
                    }
                }           
            }          
        }
        
        //in the end, check if all values in indegree is 0
        //if not 0, so courses cannot be completed
        //in this case, return false      
        for(int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] > 0) {
                return false;
            }
        }
        
        //if all indegree value is 0
        //all courses have been completed
        //return true
        return true;  
        
    }
}



/*
Example :
Graph :
0 --->1 ---> 3 ---> 5
  --->2 ---> 3
        ---> 4 ---> 5
       
No. of courses : 6 ; Course Numbers : (0,1,2,3,4,5) 
Prereq[course][prereq] :
[[1,0],[2,0],[3,1],[3,2],[4,2],[5,3],[5,4]]

Indegrees[] : No of prereq to do for index i course 
0,1,1,2,1,2
To start there has to be atleast 1 course with indegrees of 0 (no prereq required to do the course)

Map(Course, Outdegree from the course(list)) :
0 -- [1,2]
1 -- [3]
2 -- [3,4]
3 -- [5]
4 -- [5]
5 -- null


False reasons :
Cycle in Graph
*/

