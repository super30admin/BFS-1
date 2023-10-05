/*
Time Complexity  - O (V + E) V is number of courses, E is the number of prerequisites. 
Space Complexity - O(V + E) 
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int n = numCourses;
        int[] indegree = new int[n];
        ArrayList<Integer>[] adjList = new ArrayList[n];

        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<Integer>();

        for(int[] pre : prerequisites) {
            adjList[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }

        ArrayList<Integer> bfs = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) 
            if(indegree[i] == 0)
                bfs.add(i);
        
        for(int i = 0; i < bfs.size(); i++)
          for(int course : adjList[bfs.get(i)])  
            if(--indegree[course] == 0)
                bfs.add(course);
        
        return (bfs.size() == numCourses);
    }
}
