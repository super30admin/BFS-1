/**
207. Course Schedule

Leetcode: https://leetcode.com/problems/course-schedule/

There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Collabedit: http://collabedit.com/74663

Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : No
Any problem you faced while coding this : Yes
**/
class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
    
        int inDegree[] = new int[numCourses];
        
        Map<Integer, List<Integer> > hashMap = new HashMap<>();
        
        for(int edge[]: prerequisites)
        {
            inDegree[edge[0]]++;
            
            if(!hashMap.containsKey(edge[1]))
            {
                hashMap.put(edge[1], new ArrayList<>());
            }
            
            hashMap.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i: inDegree)
        {
            if( 0 == i)
                queue.add(i);
        }
        
        if(queue.isEmpty()) 
            return false;
            
        int count = 0;
        
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            
            count++;
            
            List<Integer> edges = hashMap.get(current);
            
            if(edges != null)
            {
                for( int edge : edges)
                {
                    inDegree[edge]--;
                    
                    if(inDegree[edge] == 0)
                        queue.add(edge);
                }
            
            }  
            
        }
        
        if(count == numCourses) 
            return true;
            
        return false;
            
        
    }
}
