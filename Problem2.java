//https://leetcode.com/problems/course-schedule/
// Time complexity : O(N+E)
// Space complexity : O(N+E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> adjList[] = new ArrayList[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[numCourses];
        
        for(int i=0;i<numCourses;i++)
            adjList[i] = new ArrayList<>();
        
        for(int edge[] : prerequisites){
            int pre = edge[1];
            int post = edge[0];
            adjList[pre].add(post);
            indegree[post]++;
        }
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);        
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int pre = q.poll();
            count++;
            for(int post : adjList[pre]){
                indegree[post]--;
                if(indegree[post] == 0){
                    q.add(post);
                }
            }
        }
        
        return count == numCourses;
    }
}