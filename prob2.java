// Time Complexity : O(Vertices + Edges)
// Space Complexity : O(Vertices + Edges)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N


// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] inarray = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p : prerequisites)
        {
            inarray[p[0]]++;
            if(!map.containsKey(p[1])){
                map.put(p[1], new ArrayList<>());
            }
            map.get(p[1]).add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count=0;
            for(int i=0; i< numCourses; i++)
            {
                if(inarray[i]==0) {
                    queue.add(i);
                    count++;     
                }

            }
        
        if(queue.isEmpty()) return false;
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            List<Integer> children = map.get(curr);
            if(children==null) continue;
            for(int child: children) {
                inarray[child]--;
                if(inarray[child]==0) {
                    queue.add(child);
                    count++;
                    if(count==numCourses) return true;
                }
            }
        }
        if(count<numCourses) return false;
        return true;
    }
}







