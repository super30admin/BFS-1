// Time Complexity : O(numCourses * prerequistes) -
// Space Complexity : O(n) - using extra space - queue 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Creating an array of number of courses
        int[] indegrees = new int[numCourses];
        //   Adding elements in array for prerequisutes      
        for(int i = 0; i< prerequisites.length;i++){        
                indegrees[prerequisites[i][0]]++;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>(); 
        for(int i = 0; i< indegrees.length; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int a = q.poll();
            count++;
            for(int i = 0; i<prerequisites.length; i++){
                if(a == prerequisites[i][1]){
                    indegrees[prerequisites[i][0]]--;
                    if(indegrees[prerequisites[i][0]] == 0){
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }
        if(count ==  numCourses)
            return true;
        else
            return false;  
    }
}