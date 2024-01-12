// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] degrees = new int [numCourses];//
        HashMap <Integer,List<Integer>> map = new HashMap<>();
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i < prerequisites.length; i++){
            degrees[prerequisites[i][1]]++; //
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0], new ArrayList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i = 0; i < degrees.length; i++){
            if(degrees[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
           int course = q.poll();
            List <Integer> children = map.get(course);
            if(children != null){
                for(Integer child : children){
                degrees[child]--;
                    if(degrees[child] == 0){
                        q.add(child);
                    }
                }
            }
        }
       for(int i = 0; i < degrees.length; i++){
           if(degrees[i] != 0) return false;
       }
       return true;
    }
 }