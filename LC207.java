class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int indegrees[] = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int edge[] : prerequisites)
        {
            indegrees[edge[0]]++;
            
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1],new ArrayList<>());
            }
            
            map.get(edge[1]).add(edge[0]);
        }    
            
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
            
        for(int i=0;i<numCourses;i++)
        {
            if(indegrees[i]==0)
            {
                queue.add(i);
                count++;
            }
        }
            
        if(queue.isEmpty())
        {
            return false;
        }
            
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
                
            List<Integer> lst = map.get(curr);
                
            if(lst==null)
            {
                continue;
            }
                
            for(int j: lst)
            {
                indegrees[j]--;
                
                
                if(indegrees[j]==0)
                {
                    queue.add(j);
                    count++;
                }

                if(count == numCourses)
                {
                    return true;
                }
            }
        }
        
        if(count < numCourses)
        {
            return false;
        }
        
        return true;
    }
}