class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        // Calculate indegree
        for(int i = 0; i< prerequisites.length; i++)
        {
            indegree[prerequisites[i][1]]++;
            
            if(!map.containsKey(prerequisites[i][0]))
            {
                map.put(prerequisites[i][0], new ArrayList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i< indegree.length; i++)
        {
            if(indegree[i] == 0)
                q.add(i);
        }
        
        while(!q.isEmpty())
        {
            int course = q.poll();
            List<Integer> child_nodes = map.get(course);
            if(child_nodes != null)
            {
                for(int child: child_nodes)
                {
                    indegree[child]--;
                    if(indegree[child] == 0)
                        q.add(child);
                }
            }
        }
        
        for(int i=0; i< numCourses; i++)
        {
            if(indegree[i] != 0)
                return false;
        }
        return true;
    }
}

// TC- O(Vertex+Edges)
// sc- O(Vertex + Edges)
