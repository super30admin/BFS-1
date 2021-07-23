//TC: O(|E|+|V|)
//SC: O(|E|+|V|)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        
        //build adjency list
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        
        int[] indegrees = new int[numCourses];
        
        for(int[] prereq : prerequisites) {
            int out = prereq[1];
            int in = prereq[0];
            
            if(!courseMap.containsKey(out)) {
                courseMap.put(out, new ArrayList<>());
            }
            courseMap.get(out).add(in);
            
            indegrees[in]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        
        //independent courses
        for(int i=0; i<numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }
        
        if(queue.size() == 0) return false;
        if(queue.size() == numCourses) return false;
        
        int completed = 0;
        
        while(!queue.isEmpty()) {
            //course completed
            int prereq = queue.poll();
            completed++;
            List<Integer> courses = courseMap.get(prereq);
            if(courses != null) {
                for(int course : courses) {
                    indegrees[course]--;
                    
                    if(indegrees[course] == 0) {
                        queue.add(course);
                    }
                }
            }
        }
        
        return completed == numCourses;
    }
}







