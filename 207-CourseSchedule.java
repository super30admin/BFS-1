//Approach: BFS: Using the indegree list and the Adjacency list
//Overall Time Complexity: o(V + E)
//Overall Space Complexity: O(V + E) -> As HashMap stores E+V elements
class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        if(edges.length == 0) return true;
        
        //Having an indegree array
        //Number of node a certain node is dependent on
        int[] indegree = new int[numCourses];
        //Map to store the dependence between the nodes
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] edge : edges){
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
                count++;
            } 
        }
        
        while(!q.isEmpty()){
            List<Integer> data = map.get(q.poll());
            if(data != null){
                for(int i: data){
                    indegree[i]--;
                    if(indegree[i] == 0){
                        q.add(i);
                        count++;
                        if(count == numCourses) return true;
                    }
                }    
            }
            
        }
        return false;
        
    }
}