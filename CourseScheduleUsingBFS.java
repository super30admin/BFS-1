import java.util.*;

public class CourseScheduleUsingBFS {
    //time Complexity = O(V+E)//Vertex + Edges
//Space Complexity = O(V+E)

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if(prerequisites == null || prerequisites.length==0) return true;
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            int[] indegree = new int[numCourses];
            //Filling indegree array and also adding independent:[dependent] in map
            for(int[] pr : prerequisites){ //O(E)
                indegree[pr[0]]++;
                if(!map.containsKey(pr[1])){
                    map.put(pr[1], new ArrayList<Integer>());
                }
                map.get(pr[1]).add(pr[0]);
            }
            int count =0;
            Queue<Integer> q = new LinkedList<>(); ////O(V)
            for(int i =0; i<numCourses; i++){
                if(indegree[i]==0){
                    q.add(i);
                    count++;
                }
            }

            if(q.isEmpty()) return false;
            while(!q.isEmpty()){ ////O(V+E)
                int curr  = q.poll();
                List<Integer> children  = map.get(curr);
                if(children!=null){
                    for(Integer child : children){
                        indegree[child]--;
                        if(indegree[child]==0){
                            q.add(child);
                            count++;
                        }
                        if(count == numCourses) return true;
                    }
                }
            }
            return false;
        }
    }
}
