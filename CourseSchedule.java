// Time O(V+E) where v and e are the number of vertices and edges respectively
// Space O(v+e)


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        if (prerequisites.length==0)
            return true;
        
        // We need an array to maintain indegrees
        int [] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> h = new HashMap<>();
        for(int[]p: prerequisites)
        {
            indegree[p[0]]++;
            List<Integer> temp = h.getOrDefault(p[1],new ArrayList<Integer>());
            temp.add(p[0]);
            h.put(p[1],temp);
            
            
        }
        int count =0; // count to see if all elements are processed
        Queue<Integer>q = new LinkedList<>();
        
        for(int i =0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                  q.add(i);
                 count++;
            }
        }
       
        
      
        
        while(!q.isEmpty())
        {   
            int val = q.poll();
            if(h.containsKey(val))
            {List<Integer> temp = h.get(val);
             for(Integer t:temp)
             {
                 indegree[t]--;
                 if(indegree[t]==0)
                  {q.add(t); count++;}
             }
            }
         if(count==numCourses)
             return true;
            
            
            
        }
        if(count==numCourses)return true;
        return false;
        
    }
}