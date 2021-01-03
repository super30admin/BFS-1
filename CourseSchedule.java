package S30.BFS_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*BFS Solution
Time Complexity : O(V+E) - touching every node
Space Complexity : O(
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class CourseSchedule {


    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    int[] indegree;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses == 0 || prerequisites.length == 0) return true;

        buildGraph(numCourses,prerequisites);

        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                count ++;
            }

        }

        while(!queue.isEmpty()){

            int curr = queue.poll();
            for(int v : adj.get(curr)){
                indegree[v] --;
                if(indegree[v] == 0) {
                    queue.offer(v);
                    count++;
                }
            }
        }

        return count == numCourses;


    }

    public void buildGraph(int v, int[][] prerequisites){
        indegree = new int[v];

        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
    }
}
