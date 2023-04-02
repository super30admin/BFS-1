import java.util.*;
//Leetcode -
//TC - O(V+E) , V - numberOfCourses, E - dependencies
//SC - O(V+E)
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] indegree = new int[numCourses];
        for(int [] edge : prerequisites) { //O(E)
            int out = edge[1]; // 2nd element in the pair - arrow outgoing
            int in = edge[0]; // 1st element in the pair - arrow incoming
            indegree[in]++;
            if(!map.containsKey(out)) {
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        Queue<Integer> q = new LinkedList<>();
        int count =0;
        for(int i=0; i< numCourses; i++) {//O(V)
            if(indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()) {
            int currCourse = q.poll();
            List<Integer> children = map.get(currCourse);
            if(children != null) {
                for(int child : children) {
                    indegree[child]--;
                    if(indegree[child] == 0) {
                        q.add(child);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
        if(count == numCourses) return true;
        return false;
    }
}
