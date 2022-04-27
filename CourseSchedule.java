// Time Complexity :O(V+E) - V is number of Courses and E is number of dependencies
// Space Complexity :O(V)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        for(int[] edge : prerequisites){
            indegrees[edge[0]]++;
            
            List<Integer> temp = new ArrayList<>();
            if(map.containsKey(edge[1])){
                temp = map.get(edge[1]);
            }
            temp.add(edge[0]);
            map.put(edge[1],temp);
        }
        
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                q.offer(i);
                count++;
            }
        }
        
        if(q.isEmpty()) return false;
        
        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> temp = new ArrayList<>();
            temp = map.get(course);
            if(temp != null){
                for(int edge : temp){
                    indegrees[edge]--;
                    if(indegrees[edge] == 0){
                        q.offer(edge);
                        count++;
                    }
                }
            }
        }
        
        return count == numCourses;
    }
}
