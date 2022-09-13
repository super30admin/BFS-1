// Time Complexity : O(V+E) where V is the number of vertices (numCourses) and E is the number of edges(pre req array)
// Space Complexity :O(V+E)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your

class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] edge : edges){
            indegrees[edge[0]]++;

            if(!map.containsKey(edge[1])){
                map.put(edge[1],new ArrayList<>());
            }

            map.get(edge[1]).add(edge[0]);
        }

        //BFS
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 0 ; i < numCourses  ; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }

        if(count == numCourses)
            return true;

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child: children){
                    indegrees[child]--;

                    if(indegrees[child] == 0){
                        q.add(child);
                        count++;

                        if(count == numCourses){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}