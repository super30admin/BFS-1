// Time Complexity: O(V+E)
//  Space complexity: O(n)
// Solved on leetcode successfully : Yes

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegrees = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<prerequisites.length;i++) {
            indegrees[prerequisites[i][1]]++;
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0], new ArrayList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            
        }
        
        for (int i=0;i<indegrees.length;i++) {
            if(indegrees[i]==0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int course = q.poll();
            List<Integer> children = map.get(course);
            
            if (children != null) {
            for (int child : children) {
                indegrees[child]--;
                if(indegrees[child] == 0) {
                    q.add(child);
                }
            }               
            }
 
        }
        
        for (int i=0; i<indegrees.length;i++) {
            if(indegrees[i] == 1){
                return false;
            }
        }
        
        return true;
    }
}