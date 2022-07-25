//Time Complexity: O(V+E), where v is the no. of courses & e is the no. of array elements in prerequisites.
//Space Complexity: O(V+E)
//Code run successfully on LeetCode.

public class Problem2_DFS {

    boolean[] path;
    boolean[] visited;
    HashMap<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(numCourses ==0 || prerequisites == null)
            return false;
        
         map = new HashMap<>();
        
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        
        for(int[] pre : prerequisites){
            
            int in = pre[1];
            int out = pre[0];
            if(!map.containsKey(in))
                map.put(in, new ArrayList<>());
            
            map.get(in).add(out);
        }
        
        for(int i =0; i < numCourses; i++){
            
            if(visited[i]) 
                continue;
               
            else if(hasCycle(i))
                return false;
        }
        
        return true;
    }
    
    private boolean hasCycle(int i){
        
        if(path[i] == true)
          return true;
        
        if(visited[i] == true)
         return false;
        
        path[i] = true;
        visited[i] = true;
        
        List<Integer> list = new ArrayList<>();
        
        list = map.get(i);
        
        if(list != null){
            
            for(int edge : list){
                if(hasCycle(edge))
                    return true;
            }
        }
        
        path[i] = false;
        return false;
    }
}
