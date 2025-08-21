import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SchedulingCourses {
    //Idea is to use indegree array, to keep track of indegrees of nodes.
    //Start with indegrees of zero and add it to queue. Process the elements, reduce the indegrees and add the elements 
    //with indegrees of zero to the queue, increment the count and continue processing.
    //If count becomes equal to size of numcourses, return true else return false;
    //Time Complexity: O(V+E)
    //Space Complexity: O(V+E)
        public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] pr : prerequisites){
            // pr[0] - dependent, pr[1] - independent
            indegrees[pr[0]]++;
            map.putIfAbsent(pr[1], new ArrayList<>());
            map.get(pr[1]).add(pr[0]);
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }

        if(q.isEmpty()) return false;
        if(count == numCourses) return true;

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> dependencies = map.get(curr);
            if(dependencies != null){
                for(int dependent : dependencies){
                    indegrees[dependent]--;
                    if(indegrees[dependent] == 0){
                        q.add(dependent);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }

        return false;
    }
}
