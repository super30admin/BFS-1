// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
import java.util.*;

public class CourseSchedleBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //bfs
        //happy case
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0){
            return true;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){ // populating hashmap
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]] += 1; // populating indegree
        }

        int count = 0;

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        if(queue.isEmpty()){
            return false;
        }

        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0; i < size; i++){

                int current = queue.poll();
                List<Integer> list = map.get(current);

                for(Integer j: list){
                    indegree[j] -= 1;
                    if(indegree[j] == 0){
                        queue.add(j);
                        count++;
                    }
                }
                // indegree - 1
            }
        }



        if(numCourses == count) return true;

        return false;
    }
}
