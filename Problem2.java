// Time Complexity :  O(V+E)
// Space Complexity :  O(V+E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // if(prerequisites==null || prerequisites.length==0) return true;
       HashMap <Integer, List<Integer>> map = new HashMap<>();
       int[] indegree = new int[numCourses];
       for(int[] pr : prerequisites)
       {
            indegree[pr[0]]++;
            if(!map.containsKey(pr[1])){
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add( pr[0]);
       }
       Queue<Integer> q = new LinkedList<>();
       int count=0;
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()) return false;
        if(count ==numCourses ) return true;

        while(!q.isEmpty())
        {
            int curr = q.poll();
            List<Integer> dep = map.get(curr);
            if(dep!=null) {
                for(int child : dep)
                {
                    indegree[child]--;
                    if(indegree[child]==0) {
                        q.add(child);
                        count++;
                        if(count ==numCourses ) return true;
                    }
                }
            }
        }
        return false;
    }
}
