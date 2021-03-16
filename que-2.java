// Time Complexity :O(E+V)
// Space Complexity :O(E+V)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        
        for(int[] course: prerequisites){
            int to = course[1];
            int from = course[0];
            
            inDegree[to]++;
            
            if(!hashMap.containsKey(from)){
                hashMap.put(from, new ArrayList<Integer>());
            }
            
            hashMap.get(from).add(to);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int course=0;course < numCourses;course++){
            if(inDegree[course] == 0)
                queue.add(course);
        }
        while(!queue.isEmpty()){
            int front = queue.poll();
            if(hashMap.containsKey(front)){
                for(int course: hashMap.get(front)){
                    inDegree[course]--;
                    if(inDegree[course] == 0)
                        queue.add(course);
                }
            }
        }
            for(int c : inDegree){
                if(c != 0){
                    return false;
                }
                
            }
        return true;
    } 
}