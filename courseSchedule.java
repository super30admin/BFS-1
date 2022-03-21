
//TC: V+E
//Space: o(n)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int [numCourses];
        HashMap<Integer, List<Integer>> adjMat = new HashMap<>();
        
        for(int[] edges: prerequisites)
        {
            indegree[edges[0]]++;
            if(!adjMat.containsKey(edges[1]))
            {
                adjMat.put(edges[1], new ArrayList<>());
            }
            adjMat.get(edges[1]).add(edges[0]);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i< numCourses;i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty())return false;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            List<Integer> children = adjMat.get(curr);
            if(children != null){
            for(int child : children)
            {
                indegree[child]--;
                if(indegree[child] == 0)
                    {
                        q.add(child);
                        count++;
                    }

                 }
                
            }

        }
    if (count == numCourses)return true;
    return false;
    }
}