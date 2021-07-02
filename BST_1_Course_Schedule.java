/*
 * 
 *  
 Time Complexity : O(n)
 Space Complexity : O(n)
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this :
Your code here along with comments explaining your approach: used BFS 
 * 
 * */


public class BST_1_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        int [] indegrees = new int[numCourses];
        HashMap <Integer, List<Integer>> map = new HashMap<>();
        for(int [] prereq: prerequisites){
            int in = prereq[0];
            int out = prereq[1];
            indegrees[in]++;
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< indegrees.length; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        
        if(q.size() == 0) return false;
        int count = 0;
        while(!q.isEmpty()){
           int curr = q.poll();
            count++;
            List<Integer> children = map.get(curr);
            if(children != null){
                for (int child: children){
                    indegrees[child]--;
                    if(indegrees[child]==0){
                        q.add(child);
                    }
                }
            }   
        } 
        
        if(count == numCourses) return true;
        return false;
        
    }
}