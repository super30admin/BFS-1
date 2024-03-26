import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//tc = o(V + E) v = vertices e = edges
//sc = o(V + E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            if(!map.containsKey(prereq)){
                map.put(prereq,new ArrayList<Integer>());
            }
            map.get(prereq).add(course); // this statement should not be in else
            indegree[course] = indegree[course] + 1;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
                count++;
                if(count == numCourses)return true;
            }
        }

        while(!q.isEmpty()){
            int current = q.remove();
            List<Integer> list = map.get(current);
            if(list != null){ // list can be null here so take care of this case
                for(int j : list){
                indegree[j] = indegree[j] - 1;
                if(indegree[j] == 0){
                    q.add(j);
                    count++;
                    if(count == numCourses)return true;
                }
            }
            }
            
        }
        return false;
        
    }
}