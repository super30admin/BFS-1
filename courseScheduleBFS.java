// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         HashMap<Integer, List<Integer>> map = new HashMap<>();
         int[] inDegrees = new int[numCourses];
         for(int[] edge : prerequisites){
            int out = edge[1];
            int in = edge[0];
            inDegrees[in]++;
            //make entry in the map
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
         }

         Queue<Integer> q = new LinkedList<>();
         int count = 0;
         for(int i = 0; i< numCourses; i++){
            if(inDegrees[i] == 0){
                q.add(i);
                count++;
            }
         }
         if (count == numCourses) return true;
         while(!(q.isEmpty())){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child: children){
                    inDegrees[child]--;
                    if(inDegrees[child] == 0){
                        q.add(child);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
         }
         return false;
    }
}