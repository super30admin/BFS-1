import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Time complexity - O(V+E)
Space complexity - O(V+E)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/

public class CourseSchedule_LC_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Build Graph
        int len = prerequisites.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i= 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0 ; i< len; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]); // first element should occur before second
        }

//Building inDegree for every vertex
        int [] inDegree = new int[numCourses];
        for(int i =0; i<numCourses; i++) {
            for(int it: adj.get(i)){
                inDegree[it]++;
            }
        }

        //Topo sort
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<numCourses; i++){
            if(inDegree[i] == 0)
                q.add(i);
        }

        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);
            //node is in topo now so you can remove it from inDegree

            for(int it: adj.get(node)){
                inDegree[it]--;

                if(inDegree[it] == 0){
                    q.add(it);
                }

            }
        }

        if(topo.size() == numCourses) return true;

        return false;
    }
}