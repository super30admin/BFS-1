//Time Complexity: O(V+ E).
//Space Complexity: O(n).

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] pre: prerequisites){
            int i = pre[0];
            int j = pre[1];
            indegrees[i]++;
            
            if(!adjList.containsKey(j))
                adjList.put(j, new ArrayList<>());
            adjList.get(j).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == 0)
                q.add(i);
        }
        
        
        while(!q.isEmpty()){
            
            int polled = q.poll();
            List<Integer> list = adjList.get(polled);
            if(list == null)
                continue;
            for(int edge: list){
                indegrees[edge]--;
                if(indegrees[edge] == 0)
                    q.add(edge);
            }
        }
        
       for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] != 0)
               return false;
        }
            
    return true;
    }
}