// Time Complexity :
O(V+E) V = no.of vertices(no.of courses) and E=edges(in adjacency list)
// Space Complexity :
O(V+E) we are using a hashmap, indegree array and also queue which stores vertices
// Did this code successfully run on Leetcode :
YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    
    /*
    input:
    numCourses = 6
    prerequisites = [[2,0],[4,0],[1,2],[4,2],[3,2],[5,3]]
    
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*2 cases when we can say that, graph has a cycle:
        1->When the in degree array has some value even after my queue has become empty
        2->when there is no starting point to start the BFS
        */
        //1.construct a graph using adjacency List
        
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>(numCourses);
        
        //2. Define a indegree array of size equal to noOfCourses
        int [] indegree = new int [numCourses];
        
        //3. Define a queue for BFS
        Queue<Integer> q = new LinkedList<>();
       
        
        for(int [] prerequisite : prerequisites){
            //Store edge from prequisite to the course
            int to = prerequisite[1];
            int from = prerequisite[0];
            /*As we have an incoming edge from the prerequisite course to the course that 
             has to be completed*/
            indegree[to]++ ;
            if(!adj.containsKey(from)){
                adj.put(from, new ArrayList<Integer>());
                
            }
            
            adj.get(from).add(to);
           
        
         }
        
        //Add all the vertices that have indegree as 0(no dependencies) in the queue
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
                
            }
        }
        
        //Now as our queue is ready, we can start BFS
        while(!q.isEmpty()){
           
            int x = q.poll();
            
            /*We are checking if x exists in map as there might be cases where 
            we never entered some courses into the map as they are the courses that are 
            dependent on other courses and not the prerequisites of other courses
            */
            if(adj.containsKey(x)){
               
                /*Now get the value from hashmap & reduce the indegree of the dependent                       courses*/
                for(int dc: adj.get(x)){
                    indegree[dc] -- ;
                    //after decreasing indegree, if it becomes 0, we add to queue
                    if(indegree[dc] == 0){
                        //add to queue
                        q.add(dc);
                    }
                }
                
            }
            
        }
        
    //check if all elements in indegree array are 0, to determine there is no cycle
        
        for(int z: indegree){
            if(z != 0){
                return false;
            }
             }
        //if everything is 0 we can return true, which means no cycle
        return true;
        
        
    
    
    }
        
    
}
       
    
  
    
    
