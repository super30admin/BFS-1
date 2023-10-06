// V = vertices ; E = Edges
//TC: O(V+E)
//SC: O(V+E)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        int count = 0;
        int[] indegrees = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int[] pr : prerequisites) {
            indegrees[pr[0]]++; 
            if(!map.containsKey(pr[1])) {
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null) {
                for(Integer child: children) {
                    indegrees[child]--;
                    if(indegrees[child] == 0) {
                        q.add(child);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
        return false;
    }
}
