// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> dep = new HashMap<>();
        int [] indeg = new int [numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<prerequisites.length; i++){
            indeg[prerequisites[i][0]]++;
            if(!dep.containsKey(prerequisites[i][1])){
                dep.put(prerequisites[i][1], new ArrayList<>());
            }
            dep.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for(int i=0; i<indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> child = dep.get(curr);
            if(child != null){
                for(Integer ch : child){
                    indeg[ch]--;
                    if( indeg[ch] == 0) q.add(ch);
                }
            }
        }
        
        for(int i=0 ;i<indeg.length; i++){
            if(indeg[i] != 0) return false; 
        }
        
        
        return true;
    }
}