//Course Schedule
// Time Complexity :O(E+V)
// Space Complexity :O(E+V)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :NO


import java.util.*;
public class Problem2 {
    public static void main(String[] args){
        int[][] prereq = {{0,1},{2,1},{3,2},{3,1},{1,4},{4,5}};
        int numCourses = 6;
        Problem2 p = new Problem2();
        System.out.println(p.canFinish(numCourses, prereq));

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ///tc - O(E+V) 
        //sc - O(E+V)indegree, queue, graph- E+V, 
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i< numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        ///graph -> b,a
        for(int i = 0;i< prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            indegree[a]++;
            graph.get(b).add(a);
        }
        ///System.out.println(graph);
        // push in the queue whose indegree is 0
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< indegree.length; i++){
            if(indegree[i] ==0)
                q.offer(i);
        }
        
        //main logic
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            for(int v: graph.get(curr)){
                --indegree[v];
                if(indegree[v]==0){
                    q.offer(v);
                }
            }
        }
        return count== numCourses;
        
    }
    
}
