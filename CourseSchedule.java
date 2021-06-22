//TC O(V+E)
//SC O(max(V,E))
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int [] preReq : prerequisites){ 
            int in = preReq[0];
            int out = preReq[1];
            indegrees[in]++;
            
            //build adjacency list
            if(!map.containsKey(out))
                map.put(out, new ArrayList<>());
            
            map.get(out).add(in);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        for(int i=0; i< indegrees.length; i++){
            
            if(indegrees[i] == 0 )
                q.add(i);            
        }
        //System.out.println(q);
        //no independent nodes
        if(q.isEmpty())
            return false;
        
        while(!q.isEmpty()){
            
            int cur = q.poll();
            count++;
            //System.out.println("count: "+ count + " removed: " + cur);
            List<Integer> edges = map.get(cur);
            
            if(edges != null){
              for(int edge : edges){
                  indegrees[edge]--;
                  
                  if(indegrees[edge] == 0)
                      q.add(edge);
              }  
            }
            
        }
        
        if(count == numCourses )
            return true;
        else
            return false;
        
    }
}