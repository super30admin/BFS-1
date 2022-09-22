// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Topological sort method
First calculate indegrees and form the adjList
Add indegree==0 nodes to queue
Perform BFS, reduce indegree at eah level and when indegree is zero add to queue
finally if any node has indegree>0 then return false else true
*/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList= new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adjList.add(new ArrayList<Integer>());

        int[] indegree= new int[numCourses];
        for(int[] prerequisite: prerequisites){
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue= new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int qs=queue.size();
            for(int i=0;i<qs;i++){
                int node=queue.poll();
                for(int nn: adjList.get(node)){
                    indegree[nn]--;
                    if(indegree[nn]==0)
                        queue.offer(nn);
                }
                numCourses--;
            }
        }
        return numCourses==0;
    }
}
