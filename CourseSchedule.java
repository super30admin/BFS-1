// Time Complexity :O(V+E)
// Space Complexity :O(V+E)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: topological sort
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList= new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        
        int indegree[]= new int[numCourses];
        for(int prerequisite[]:prerequisites){
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> q= new LinkedList<>();

        for(int i=0; i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int course=q.poll();
            for(int neighbor:adjList.get(course)){
                indegree[neighbor]--;

                if(indegree[neighbor]==0){
                q.offer(neighbor);
            }
            }
            
        }
        for(int degree:indegree){
            if(degree>0){
                return false;
            }
        }
        return true;
    }
}