// Time Complexity : O(V+E) V number of verticess and E is number of edges
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No 
class Solution {
    
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(prerequisites==null || prerequisites.length==0) return true;
        
        int [] indegree = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] edge : prerequisites)
        {
            indegree[edge[0]]++;
            List<Integer> temp = map.getOrDefault(edge[1],new ArrayList<Integer>());
            temp.add(edge[0]);
            map.put(edge[1],temp);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        int count =0;
        while(!q.isEmpty())
        {
            int curr = q.remove();
            count++;
            List<Integer> temp = map.get(curr);
            if(temp != null)
            {
               for(int i:temp)
               {
                indegree[i]--;
                if(indegree[i]==0)
                {
                    q.add(i);
                }
               }   
            }   
        }
        System.out.print(count);
        return count==numCourses;
    }
}