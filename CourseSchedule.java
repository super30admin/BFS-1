// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Use BFS and Topological sort
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0)
            return true;
        
        int[] inDegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int[] prerequisite: prerequisites ) {
            int in = prerequisite[0];
            int out = prerequisite[1];
            inDegree[in]++;
            
            if(!map.containsKey(out)) {
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
               
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        if(queue.isEmpty())
            return false;
        
        int count = 0;
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            count++;
            List<Integer> dependents = map.get(curr);

            if(dependents != null) {
                for(int i: dependents) {
                    inDegree[i]--;
                    if(inDegree[i] == 0)
                        queue.add(i);
                }
            }
        }
        
        return count == numCourses;
    }
}