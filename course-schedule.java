
//TC is O(V+E)
//SC is O(V+E)
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) {
            return true;
        }

        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int completedCourses = 0;

        for (int[] edge : prerequisites) {
            int in = edge[0];
            int out = edge[1];

            indegrees[in]++;

            if (!map.containsKey(out)) {
                map.put(out, new ArrayList<>());
            }

            map.get(out).add(in);
        }

        // now we have indegrees array and adjacancy list built

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                completedCourses++;
            }
        }

        // start bfs
        while (!q.isEmpty()) {
            int curr = q.poll();

            List<Integer> edges = map.get(curr);

            if (edges != null) {
                for (int edge : edges) {
                    indegrees[edge]--;
                    if (indegrees[edge] == 0) {
                        completedCourses++;
                        q.add(edge);
                    }
                }
            }
        }

        // //now we iterate over n degrees
        // for(int i=0; i<indegrees.length; i++){
        // if(indegrees[i]!=0){
        // return false;
        // }
        // }

        return completedCourses == numCourses;
    }
}