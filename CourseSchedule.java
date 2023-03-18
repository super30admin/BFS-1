import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> courses = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int[] each: prerequisites){
            indegree[each[0]]++;
            if(!courses.containsKey(each[1])){
                courses.put(each[1],new ArrayList<>());
            }
            courses.get(each[1]).add(each[0]);
        }
        int count = 0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()) return false;

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> dependent = courses.get(curr);
            if(dependent!=null){
                for(int dep:dependent){
                    indegree[dep]--;
                    if(indegree[dep] == 0){
                        q.add(dep);
                        count++;
                        if(count == numCourses) return true;
                    }

                }
            }

        }
        return count==numCourses;
    }
}
