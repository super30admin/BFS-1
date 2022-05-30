// Time Complexity : O(V + E) where V is the number of courses and E is the number of dependencies
// Space Complexity : O(V + E) where V is the number of courses and E is the number of dependencies
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int coursesCompleted = 0;
        
        // populating the inDegrees array and the map
        for(int[] edge: prerequisites) {
            int independent = edge[1];
            int dependent = edge[0];
            
            inDegrees[dependent] += 1;
            
            if(map.containsKey(independent)) {
                map.get(independent).add(dependent);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(dependent);
                map.put(independent, temp);
            }
        }
        
        // looping over the inDegrees array and finding the independent nodes to add in the queue
        for(int i = 0; i < numCourses; i += 1) {
            if(inDegrees[i] == 0) {
                q.add(i);
                coursesCompleted += 1;
            }
        }
        
        // performing BFS to find the courses which can be completed
        while(!q.isEmpty()) {
            int temp = q.poll();
            List<Integer> tempList = map.get(temp);
            if(tempList == null) {
                continue;
            }
            
            for(int node: tempList) {
                inDegrees[node] -= 1;
                if(inDegrees[node] == 0) {
                    q.add(node);
                    coursesCompleted += 1;
                }
            }
        }
        
        return coursesCompleted == numCourses;
    }
}