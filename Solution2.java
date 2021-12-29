// Time Complexity :O(V+E) V is number of vertices in the adjacency list and E being the edges in adjancy list.
// Space Complexity :O(V+E) maximum number of elements in a queue at one time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//This is topological sort implemented via BFS

public class Solution {
    //BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree= new int[numCourses];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        int total=0;
        
        if (numCourses==0)
           return true;

        for(int[] course :prerequisites){
            indegree[course[0]]++;            
            if(!map.containsKey(course[1])){
                map.put(course[1],new ArrayList<Integer>());               
            }
            map.get(course[1]).add(course[0]);
        }
        
        for (int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
            
        while(!q.isEmpty()){
            int curr = q.poll();
            // as soon as we access one course we add it to the total
            total++;
            List<Integer> edges= map.get(curr);
            //check if the course edges exists in the map
            if(edges!=null){
            for(int edge :edges){
                indegree[edge]--;
                if(indegree[edge]==0){
                    q.add(edge);
                }
            }
            }
        }
        
        return total==numCourses;
    }

// Time Complexity :O(V+E) V is number of vertices in the adjacency list and E being the edges in adjancy list.
// Space Complexity :O(V+E) maximum number of elements in a recursive stack at one time,O(V) size of path and visited array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//DFS
// path stores all elements in the current path. In the backtracking step, we are reseting the path to false, but if we encounter a node in the path that means there is a cycle
boolean[] path;
boolean[] visited;
HashMap<Integer,List<Integer>> map;
public boolean canFinish1(int numCourses, int[][] prerequisites) {
   if (numCourses==0)
       return true;
    path = new boolean [numCourses];
    visited = new boolean [numCourses];
    map=new HashMap<>();
    for(int[] course :prerequisites){           
        if(!map.containsKey(course[1])){
            map.put(course[1],new ArrayList<Integer>());               
        }
        map.get(course[1]).add(course[0]);
    }
    
    for(int i=0;i<numCourses;i++){
        if(!visited[i] && dfs(i)){
            return false;
        }
    }
    
    return true;
    
}
private boolean dfs(int course){
    //base
    if(path[course]){
        return true;
    }
    if(visited[course]){
        return false;
    }        
    //logic
    path[course]=true;
    visited[course]=true;
    List<Integer> edges=map.get(course);
    if(edges!=null){
        for(int edge:edges){
          if(dfs(edge)){
              return true;
          }
        }
    }
    path[course]=false;
    return false;
}

}
