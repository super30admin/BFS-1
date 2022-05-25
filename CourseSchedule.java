/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
 */
class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0)
            return true;
        
        // this array is used to keep the track of count of prerequisite courses
        int inDegree[] = new int[numCourses];
        
        // this map stores the course -> Dependent Courses 
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // this queue is used to perform the BFS
        Queue<Integer> queue = new LinkedList<>();
        
        /**
           This loop iterates over the prerequisites and increment the counter of prerequisites
        **/
        for(int val[]: prerequisites)
        {
            inDegree[val[0]]++;
            if(!map.containsKey(val[1]))
            {
                map.put(val[1], new ArrayList<>());
            }
            
            map.get(val[1]).add(val[0]);
        }
        
        int index = -1;
        
        // add all the independent courses inside the queue
        for(int i=0; i<numCourses; i++)
        {
            if(inDegree[i]==0)
            {
                index = i;
                queue.add(i);
            }
        }
        
        if(index == -1)
            return false;
        
        while(!queue.isEmpty())
        {
            // once the currentCourse is completed the indegree of the dependent needs to be reduced by 1
            int currentCourse = queue.poll();
            
            // getting the list of dependent courses
            List<Integer> dependentCourses = map.get(currentCourse);
            
            if(dependentCourses != null)
            {
                for(int dependentCourse: dependentCourses)
                {
                    // reducing the indegree of dependent courses by 1
                    inDegree[dependentCourse]--;
                    
                    // if the indegree becomes , it means that course has become independent and ready to be taken
                    if(inDegree[dependentCourse] == 0)
                    {
                        // add the independent course to the queue
                        queue.add(dependentCourse);
                    }
                }
            }
        }
        
        /**
            loop through the courses to find any course which still has a pending prerequisite 
            if any course is found meeting that criteria it means that all the courses cannot be completed 
        **/
        for(int i=0; i<numCourses; i++)
        {
            if(inDegree[i]!=0)
                return false;
        }
        
        
        return true;
        
    }
}