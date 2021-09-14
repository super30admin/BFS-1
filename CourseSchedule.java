package BFS1;
// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int count = 0;
        for(int[] edge : prerequisites){
            indegree[edge[0]]++;
            if(!adjList.containsKey(edge[1])){
                adjList.put(edge[1], new ArrayList<>());
            }
            adjList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i< indegree.length; i++){
            if(indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty())
            return false;
        while(!q.isEmpty()){
            int node = q.poll();
            List<Integer> nbrs = adjList.get(node);
            if(nbrs != null){
                for(int nbr : nbrs){
                    indegree[nbr]--;
                    if(indegree[nbr] == 0){
                        q.add(nbr);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(2, new int[][]{{1, 0}}));
    }
}
