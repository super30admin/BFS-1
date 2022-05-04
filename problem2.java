import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.Query;

class courseSchedule{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0 ) return true;

        int[] indegress = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge : prerequisites){
            indegress[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }

        int count = 0;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegress[i] == 0){
                q.add(i);
                count++;
            }
        }

        if(q.isEmpty()) return false;

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if(edges != null){
                for(int edge : edges){
                    indegress[edge]--;
                    if(indegress[edge] == 0){
                        q.add(edge);
                        count++;
                    }
                }
            }
        }

        return count == numCourses;
    }
}


//problem2. java has O(V+E) time complexity and O(Vertics) space compelexity