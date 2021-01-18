// Time Complexity : The time complexity is O(n) where n is the length of the prerequisites array
// Space Complexity : The space complexity is O(n) where n is the length of the prerequisites array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            map.put(i,new LinkedList<>());
        }

        // Create mapping for each prerequisite course with the normal course
        for(int i=0;i<prerequisites.length;i++){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i=0;i<numCourses;i++){

            if(!hasCycle(i,map,visited)){
                return false;
            }
        }

        return true;

    }

    // Check for cycle
    public boolean hasCycle(int i,Map<Integer,List<Integer>> map,boolean[] visited){

        if(visited[i] == true){
            return false;
        }

        visited[i] = true;

        for(int j:map.get(i)){
            if(!hasCycle(j,map,visited)){
                return false;
            }
        }
        visited[i] = false;
        return true;
    }
}