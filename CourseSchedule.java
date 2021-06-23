/*SC - O(V+E) TC O(V+E) */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      
        //1. construct a graph with hm keys as node on which the value (list of nodes) is dependant on and an indegree array which keeps tracks of the number of depedancies every course has. if the dependency boils down to zero, we can add the node to the queue , indicating that can be considrered as done
        // 2.add the independant nodes in the queue and increment a counter to keep track of nodes being added to queue
        // 3. if the above counter == number of courses => we were able to finish all the courses and thus true
        // Note- if there was a cycle, the participating nodes would never make it to the queue since its inedgree would never become zero
        
        Map<Integer, List<Integer>> map= new HashMap<>();
        
        int[] indegree = new int[numCourses];
        
        // construc the grpah
        for(int[] prerequisite:prerequisites ){
            int in = prerequisite[0];
            int out = prerequisite[1];
            indegree[in] +=1 ;
            if (!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        
        // add the indepenedant nodes to the 
        // if indegre is zero, its an independant node 
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < indegree.length; i++){
            if (indegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0 ;
        while(!queue.isEmpty()){
            int elem = queue.poll();
            count += 1;
            // check its dependencies from the map
            List<Integer> children  = map.get(elem);
            if (children !=null){
                
                for(int child: children){
                    indegree[child] -= 1;
                    if (indegree[child] == 0){
                        queue.add(child);
                    }
                }
            }
        }
        
        
        return count == numCourses;
        
    }
}
