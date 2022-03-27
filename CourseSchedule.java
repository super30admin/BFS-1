// Time Complexity : O(V+E)
// Space Complexity : O(n)
//  1. Creating Map - O(no of prerequeisites) + O(n) for indegree counter
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/668430134/)
// Any problem you faced while coding this : No
// My Notes : 

class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        // Creating map and indegree counter
        for(int i =0; i<pre.length;i++){
            // System.out.println(" Pre Course : "+i+" - "+pre[i][0] +","+pre[i][1]);
            int preCourse = pre[i][1];
            int destCourse = pre[i][0];
            // to destCourse, finish precourse
            
            // Add path from pre to dest
            map.computeIfAbsent(preCourse, k -> new ArrayList<Integer>()).add(destCourse);
            ++indegree[destCourse];
        }
        //System.out.println(" Map  : "+map);

        // add the elements with indegree 0 to the queue.
        boolean isIndegreePresent = false;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            // visit the node neighbors
            if(indegree[i] == 0){
                //System.out.println(" IndegreeO : "+i);
                isIndegreePresent = true;
                queue.add(i);
            }
        }
        // If no element present with indegree 0; then there is loop
        if(!isIndegreePresent){return false;}
        
        // check loop using bfs indegree counter
        int courseCount = 0;
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            courseCount++;
            if(map.get(node) != null){
                for(Integer neighbor : map.get(node)){
                    if(--indegree[neighbor]==0){
                        queue.add(neighbor);
                    }
                }
            }
            
        }
        // if poll equal to numCourses then true;
        return courseCount == numCourses;
    }
}