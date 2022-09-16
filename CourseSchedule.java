//tc - o(v+e)
//sc -o(v+e)
class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        int[]indegrees = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int count=0;
        for(int[] edge : edges)
        {
            indegrees[edge[0]]++;
            
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1],new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        //bfs
               Queue<Integer> q = new LinkedList<>();
               for(int i=0 ;i<numCourses;i++)
               {
                   if(indegrees[i] == 0)
                   {
                       q.add(i);
                       count++;
                   }
               }
               if(count == numCourses) return true;
               while(!q.isEmpty())
               {
                   int curr = q.poll();
                   List<Integer> children = map.get(curr);
                   if(children != null)
                   {
                       for(int child : children)
                       {
                           indegrees[child]--;
                           if(indegrees[child]==0)
                           {
                               q.add(child);
                               count++;
                               if(count == numCourses) return true;
                           }
                       }
                   }
                  
                   
               }
               return false;
        
    }
}