//Time Complexity: O(V+E), where v is the no of courses & e is the no of array elements in prerequisites.
//Space Complexity: O(V+E)
//Code run successfully on LeetCode.

public class Problem2_BFS {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(numCourses ==0 || prerequisites == null)
            return false;
        
        
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] pre : prerequisites){
            
            int in = pre[1];
            int out = pre[0];
            
            indegree[out]++;
            
            if(!map.containsKey(in))
                map.put(in, new ArrayList<>());
            
            map.get(in).add(out);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i =0; i < numCourses; i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        
        while(!q.isEmpty()){
            
            int curr = q.poll();
        
            List<Integer> list = new ArrayList<>();
            list = map.get(curr);
            
            if(list != null){
                
                for(int edge : list){
                    
                    indegree[edge]--;
                    if(indegree[edge] == 0)
                        q.add(edge);
                }
            }
        }
        
        for(int i =0; i < numCourses; i++){
            
            if(indegree[i] != 0)
                return false;
        }
          
        return true;
    }
}
