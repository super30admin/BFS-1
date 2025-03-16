// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        if(prerequisites == null || prerequisites.length == 0) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p : prerequisites){
            indeg[p[0]]++;
            if(!map.containsKey(p[1])){
                map.put(p[1], new ArrayList<>());
            }
            map.get(p[1]).add(p[0]);

        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indeg.length ; i++){
            if(indeg[i] == 0){
                q.add(i);
                count++;
            }
        }

        if(q.isEmpty())return false;
        if(count == numCourses) return true;

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> child = map.get(curr);
           if(child!= null){
                for(int c : child){
                    indeg[c]--;
                    if(indeg[c] == 0){
                        count++;
                        if(count == numCourses) return true;
                        q.add(c);
                    }
                }
           } 
            
        }

        return false; 


        

        
    }
}