//bfs

//time- o(v+e)
//space- o(v+e)
//passed in leetcode- yes

//input- [ [1,0], [2,0] , [3,1] ,[3,2] , [3,4] ]
// ele[0]-1
// ele[1]-0

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap();
        int[] indegrees = new int[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int[] ele : prerequisites)
        {
            indegrees[ele[0]]++; //populate indegrees array
            
            if(!hm.containsKey(ele[1])) // populate hashmap, pre-requisite to course mapping
            {
                 hm.put(ele[1], new ArrayList<Integer>());
            }
            hm.get(ele[1]).add(ele[0]);
           
        }
        
        for(int i =0 ; i <numCourses; i++)// check for independent courses
        {
            if(indegrees[i]==0)
            {
                q.add(i);
            }
            
        }
        
        if(q.isEmpty()) return false; //means there is no independent course 
            
        while(!q.isEmpty()) //go through the courses
        {
            //take size of the q, if we need to return how many semesters to complete all courses
            int course = q.poll();
            if(hm.get(course) == null) continue; // if there are no courses dependent on curr course
            List<Integer> dependents = hm.get(course);//get dependent courses from map
                        
                for(int i: dependents)//iterate through dependents and add to q, and decrement dependency
                { 
                    indegrees[i]--;  
                    if(indegrees[i]==0)
                    {
                        q.add(i);
                    }
                }        
        }
        
       for(int i : indegrees)// check for independent courses
        {
            if(i!=0)
            {
               return false;
            }
        }
        
        return true;

        
    }
}