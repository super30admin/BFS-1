// S30 Big N Problem #55 {Medium}
// 207. Course Schedule
// Time Complexity :O(v*e) where v is vertices(courses) and e is edges(pairs)
// Space Complexity :O(v+e) where v is stored in hashmap and e is the stored in form of queue
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] dependency = new int[numCourses];
        HashMap <Integer,List<Integer>> map = new HashMap<>();
        
        //filling hashmap and queue
        for(int i=0;i<prerequisites.length;i++){
            dependency[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1],new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        //filling queue with courses having 0 dependencies in initial phase
        Queue <Integer> q=new LinkedList<>();
        for(int i=0;i<dependency.length;i++){
            if(dependency[i]==0) q.add(i);
        }
        
        while(!q.isEmpty()){
            int course=q.poll();
            List<Integer> dependentcourse=map.get(course);
            if(dependentcourse!=null){
                for(int child:dependentcourse){
                    dependency[child]--;
                    if(dependency[child]==0) q.add(child);
                }
            }
        }
        
        for(int i=0;i<dependency.length;i++){
            if(dependency[i]>0) return false;
        }
        return true;
    }
}