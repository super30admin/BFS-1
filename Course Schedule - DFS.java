// Time Complexity : O(V+E)// vertices + edges //O(max(V,E))
// Space Complexity : O(V+E)+O(V)+O(V)+O(V)(hashmap - adjacency list,recursive stack no. of vertices, path array,
//visited array respectively) --> O(V+E)(higher order term)
// Did this code successfully run on Leetcode 207:yes
/*Approach - whenever we are visiting a node for the first time we are setting visited of that node to true
and also adding it to the path by setting it to true; when there are no children then we have to go back to parent
ie, removing the parent from the existing path by setting the path to false ; we have encounter a cycle and if the visited of that node
 is still false it means we can no longer go further */
 /* When the cycle is detected? when the path of the node is already true and now we are trying to include
 it in our path which means there is cycle which lead us to the same node*/


    class Solution {
    boolean[] path;
    boolean[] visited;
    HashMap<Integer,List<Integer>> hm;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         int courses=0;
        if(numCourses == 0)
            return true;
        path=new boolean[numCourses];
        visited=new boolean[numCourses];
        hm=new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            if(!hm.containsKey(prerequisites[i][1]))
            {
                hm.put(prerequisites[i][1],new ArrayList<>());
            }
            hm.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i] && hasCycle(i))
                return false;
        }

       return true;
    }
    private boolean hasCycle(int i){
        if(path[i])return true;
        if(visited[i])return false;

        visited[i]=true;
        path[i]=true;
        List<Integer> edges=hm.get(i);
        if(edges!=null){
            for(int edge:edges){
               if(hasCycle(edge))
                   return true;
            }

        }
        path[i]=false;
        return false;
    }
}