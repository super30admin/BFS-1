
public class CourseSchedule{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] p: prerequisites){
            indegrees[p[0]]++;
            if(map.get(p[1]) == null){
                map.put(p[1], new ArrayList<>());
            }
            map.get(p[1]).add(p[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                q.offer(i);
                count++;
            }
        }     
        if(count == numCourses) return true;       
        if(q.isEmpty()){
            return false;
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> dep = map.get(curr);
            if(dep != null){
                for(int d: dep){
                    indegrees[d]--;
                    if(indegrees[d] == 0){
                        q.offer(d);
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