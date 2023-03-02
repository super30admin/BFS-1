//T.C- O(∣E∣+∣V∣) where ∣V∣ is the number of courses, and ∣E∣ is the number of dependencies.
//S.C- O(∣E∣+∣V∣), graph data structure would consume this space
import java.util.ArrayList;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj= new ArrayList[numCourses];//Array of lists ds
        //make adjency list
        for(int i=0; i<numCourses; i++){
            adj[i]= new ArrayList<>();
        } //add the values to the adjency list
        for(int [] pre: prerequisites){
            adj[pre[0]].add(pre[1]);
        }
        // for(int i=0; i<adj.length;i++){
        //     System.out.print(adj[i]);    //check if the adjency list is proper
        // }
        int [] visited= new int[numCourses]; //(0 -> unvisited, 1 -> visited, 2 -> completed)
        for(int i=0; i<numCourses;i++){
            if(visited[i]==0){ //is a cycle is detected then false
                if(dfscycle(visited,i,adj)){ //if function return true then cycle-> FALSE
                    return false;
                }
            }
        }
        return true;
        
    }
    public boolean dfscycle(int[] visited, int node,ArrayList<Integer>[] adj ){
        if(visited[node]==1){ //if we comback to the visited node then a cycle is present
            return true; 

        }
        if(visited[node]==2){ //if we come abck to a completed noted then no cycle
            return false;
        }
        visited[node]=1; //mark as visited
        for(int n: adj[node]){ // DFS of all the other nodes current "node" is connected to
           if(dfscycle(visited, n, adj)){
                return true; //if cycle detected 
            }
            
        }
 // If no more other nodes for the current "node" mark as completed and return false        
        visited[node]=2;
        return false;
    }
}