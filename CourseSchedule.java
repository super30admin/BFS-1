/*
 *  Time Complexity: O(V+E) Where V is the number of nodes and E is the number of edges.
 *  Space Complexity: O(V+E) Where V is the number of nodes and E is the number of edges.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : Design the approach to hold the min element.
 *
 *  Explanation: In Topological sorting we first create a map which has key as node and value as list of  edge that are dependent on this node. Now we create an array of length of number of courses and store the number of dependencies that this node has. Now we put the node that have zero dependencies and traverse through list of edges in map and reduce the in degress value in the array. If any node reduces to zero degree we then add that node to the queue and process it. In the last if we have any node with inDegree greater than equal to 1 we return false else true.
 */
class Solution {
    //Topological Sorting:
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0) return true;
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] prereq: prerequisites){
            inDegree[prereq[0]]+=1;
            List<Integer> list;
            if(!graph.containsKey(prereq[1])){
                graph.put(prereq[1],new ArrayList<>());
            }
            graph.get(prereq[1]).add(prereq[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0) queue.add(i);
        }
        int cnt=0;
        
        while(!queue.isEmpty()){
            int currNode = queue.poll();
            cnt++;
            List<Integer> list= graph.get(currNode);
            if(list!=null){
                for(int n:list){
                    inDegree[n]--;
                    if(inDegree[n]==0){
                        queue.add(n);
                    }
                }    
            }
            
        }
      return cnt==numCourses;  
    } 
}

    // DFS:
//     HashMap<Integer, List<Integer>> graph;
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         if(numCourses==0) return true;
//         graph = new HashMap<>();
//         createGraph(prerequisites);
//         return traversGraph(numCourses);
//     }
    
//     enum STATUS{
//         NOT_VISITED,
//         VISITING,
//         VISITED
//     }
    
//     private void createGraph(int[][] prerequisites){
//         for(int[] prereq : prerequisites){
//             if(!graph.containsKey(prereq[0])){
//                 graph.put(prereq[0],new ArrayList<Integer>());
//             }
//             graph.get(prereq[0]).add(prereq[1]);
//         }
//     }
    
//     private boolean traversGraph(int numCourses){
//         STATUS[] visited = new STATUS[numCourses];
//         for(int i=0;i<visited.length;i++){
//             visited[i]=STATUS.NOT_VISITED;
//         }
//         for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet()){
//             if(!dfs(entry.getKey(), visited)) return false;
//         }
//         return true;
//     }
    
//     private boolean dfs(int node, STATUS[] visited){
//         if(visited[node]==STATUS.VISITING) return false;
//         if(visited[node]==STATUS.VISITED) return true;
//         visited[node]=STATUS.VISITING;
//         if(graph.get(node)==null){
//             visited[node]=STATUS.VISITED;
//             return true;  
//         } 
//         for(int edge : graph.get(node)){
//             if(!dfs(edge, visited)) return false;    
//         }
//         visited[node]=STATUS.VISITED;
//         return true;
//     }
// }    
    
