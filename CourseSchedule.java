// Time Complexity : O(n + m) n is number of courses and m is number of dependencies
// Space Complexity :O(m + n) n is number of courses and m is number of dependencies
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int [] dependencies = new int [numCourses];
        
        //Stores prereqs and list of courses that need this prereq
        HashMap <Integer,List<Integer>> map = new HashMap<>();
        Queue <Integer> queue = new LinkedList<>();

        //Fill hash map
        for(int i = 0; i < prerequisites.length; i++){
            dependencies[prerequisites[i][1]]++; //
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0], new ArrayList<>());
            } 
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        //add independent courses to queue
        for(int i = 0; i < dependencies.length; i++){

            if(dependencies[i] == 0){ //Pick courses that aren't dependent on others
                 queue.add(i);
            } 
        } 

        //Process elements in queue and add newly independent courses to queue
        while(!queue.isEmpty()){
           int course = queue.poll();
            List <Integer> children = map.get(course);
            if(children != null){
                for(Integer child : children){
                dependencies[child]--; 
                    if(dependencies[child] == 0){
                        queue.add(child);
                    }
                }
            }
        }

        //return false if courses are unfinished
       for(int i = 0; i < dependencies.length; i++){
           if(dependencies[i] != 0) return false;
       }

       return true;
    }
}
