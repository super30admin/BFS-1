// Time Complexity :O(V + E)
// Space Complexity :O(V + E) V- Vertex E - Edges
// Did this code successfully run on Leetcode :yes \
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree=new int[numCourses];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        for(int[] eachEdge:prerequisites)
        {
            degree[eachEdge[0]]++;
            if(!map.containsKey(eachEdge[1]))
                map.put(eachEdge[1],new ArrayList<>());
            map.get(eachEdge[1]).add(eachEdge[0]);
        }
        
        for(int i=0;i<degree.length;i++)
        {
            if(degree[i]==0)
                q.add(i);
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty())
        {
            int temp=q.poll();
            if(map.containsKey(temp))
            {
                List<Integer> list=map.get(temp);
                for(Integer each:list)
                {
                    degree[each]--;
                    if(degree[each]==0)
                        q.add(each);
                }
            }
        }
        for(int i=0;i<degree.length;i++)
        {
            if(degree[i]>0)
                return false;
        }
        return true;
        
    }
}