// Time Complexity : O(V+E) 
// Space Complexity : O(V+E) 
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/course-schedule/
// Any problem you faced while coding this : No


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // First step is to create indegree array as well as hasmap to store the values
        HashMap<Integer,List<Integer>> result = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] edge:prerequisites){
            int out = edge[1]; //independent
            int in = edge[0];
            indegrees[in]++;
            // check if map contains enteries for out
            if(!result.containsKey(out)){
                result.put(out,new ArrayList<>());
            }
            result.get(out).add(in);
        }

        // Next step is BFS which we will start with Queue.
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                queue.add(i);
                count++;
            }
        }
            if(count==numCourses) return true;
            while(!queue.isEmpty()){
                int element = queue.poll();
                // Get the list of dependentCourses from the map
                List<Integer> dependentCourses = result.get(element);
                if(dependentCourses!=null){
                    for(int j:dependentCourses){
                         indegrees[j]--;
                         if(indegrees[j]==0){
                            queue.add(j);
                            count++;
                            if(count==numCourses) return true;
                         }
                          
                    }
                }
            }
           return false;
    }
}
