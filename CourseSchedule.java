// Time Complexity : O(E+V)
// Space Complexity : O(E+V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 1)
            return true;
        
        Map<Integer,List<Integer>> courseDependencyMap = new HashMap<>();
        int[] dependencyCount = new int[numCourses];
        
        for(int[] preReq : prerequisites) {
            if(!courseDependencyMap.containsKey(preReq[0]))
                courseDependencyMap.put(preReq[0], new ArrayList<Integer>());
            
            courseDependencyMap.get(preReq[0]).add(preReq[1]);
            dependencyCount[preReq[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++) {
            if(dependencyCount[i]==0)
                queue.add(i);
        }
        
        while(!queue.isEmpty()) {
            int course = queue.poll();
            if(courseDependencyMap.containsKey(course)) {
                for(int dependent : courseDependencyMap.get(course)) {
                    dependencyCount[dependent]--;
                    if(dependencyCount[dependent]==0)
                        queue.add(dependent);
                }
            }
            numCourses--;
            if(numCourses==0)
                return true;
        }
        
        return false;
    }
}
