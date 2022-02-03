//T.C = 0(V+E)
//S.C =0(V+E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegrees = new int[numCourses];
        int count = 0;
        for(int i=0;i<prerequisites.length;i++)
        {
            indegrees[prerequisites[i][0]]++;
        }
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<prerequisites.length;i++)
        {
            if(!map.containsKey(prerequisites[i][1]))
            map.put(prerequisites[i][1],new ArrayList<Integer>());
            
            
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegrees.length;i++)
        {
            if(indegrees[i]==0)
                
            {
                q.add(i);
            }
        }
        
        while(!q.isEmpty())
        {
            int curr = q.poll();
            count++;
            List<Integer> deps = map.get(curr);
            if(deps!=null){
            for(int dep : deps)
            {
                indegrees[dep]--;
                if(indegrees[dep]==0)
                {
                    q.add(dep);
                }
            }
            }
        
        }
        if(count==numCourses)
        {
            return true;
        }
        return false;
        
    }
}