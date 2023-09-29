import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for(int[] prerequisite : prerequisites){
            int to = prerequisite[0];
            int from = prerequisite[1];
            indegrees[to]++;
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        if(q.isEmpty()){
            return false;
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer>edges = map.get(curr);
            if(edges == null){
                continue;
            }
            for(int edge : edges){
                indegrees[edge]--;
                if(indegrees[edge] ==0 ){
                    q.add(edge);
                }
            }
        }
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i] != 0){
                return false;
            }
        }
        return true;
    }
}