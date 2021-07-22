// Time Complexity : O(|E| + |V|) where E: edges, V: vertices
// Space Complexity : O(|E| + |V|) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        
        //build the graph -adj list
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        
        //dependency array - indegrees
        int[] indegrees = new int[numCourses];
        
        for(int[] prereq: prerequisites){
            int out = prereq[1];
            int in = prereq[0];
            
            if(!courseMap.containsKey(out)){
                courseMap.put(out, new ArrayList<>());
            }
            courseMap.get(out).add(in);
            indegrees[in]++;
            
            }
        Queue<Integer> queue = new LinkedList<>();
        //independent courses added to queue
        for(int i=0; i<numCourses; i++){
            if(indegrees[i] == 0)
                queue.add(i);
        }
        
        if(queue.size() == 0) return false;
        if(queue.size() == numCourses) return true;
        int completed = 0;
        
        while(!queue.isEmpty()){
            int prereq = queue.poll();
            completed++;
            
            List<Integer> courses = courseMap.get(prereq);
            
            if(courses != null){
                for(int course: courses){
                    //reduce prereq count
                    indegrees[course]--;
                
                
                //ready to take course
                if(indegrees[course] == 0)
                    queue.add(course);
            }
        }
        }   
    
    return completed == numCourses;
    }
}