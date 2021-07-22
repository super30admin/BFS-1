
// Time Complexity : o(e+v)
// Space Complexity : o(e+v)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(prerequisites==null && numCourses==0)
            return true;
        
        //build graph - adj list
        Map<Integer,List<Integer>> courseMap=new HashMap<>();
        
        // dependency array
        int[] indegrees=new int[numCourses];
        
        for(int[] preq:prerequisites)
        {
            int out=preq[1];
            int in=preq[0];
            
            if(!courseMap.containsKey(out))
                courseMap.put(out,new ArrayList<>());
               
            courseMap.get(out).add(in);
            indegrees[in]++; // in has preq course out so in value is incremented in dependency
            
        }
        
        Queue<Integer> queue =new LinkedList<>();
        
         for(int i=0;i<numCourses;i++)
         {
             if(indegrees[i]==0)
                 queue.add(i);
         }
        
         if(queue.size()==0) return false;
         if(queue.size()==numCourses)
             return true;
        int completed=0;
        
        while(!queue.isEmpty())
        {
           int prereq= queue.poll();
            completed++;
            List<Integer> courses=courseMap.get(prereq);
           
            if(courses!=null)
            {
               for(int course:courses)
               {
                   indegrees[course]--;
                
                   if(indegrees[course]==0)
                     queue.add(course);
                
               }
                
            }
        }
          
        return completed==numCourses;
    }
}