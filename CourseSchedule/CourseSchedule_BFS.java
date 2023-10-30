/* Time Complexity : O(V+E) 
 *  V - no. of nodes/vertices in a graph 
 *  E - no. of edges in the graph */
/* Space Complexity : O(V+E) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Maintain dependency count for each node/vertex
        int[] inDegrees = new int[numCourses];
        //Maintaing dependencies for each node
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //Iterate over the prerequisites array and populate the inDegrees array and hashmap
        for(int[] pr : prerequisites){
            int in = pr[0]; //dependent
            int out = pr[1]; //independent
            inDegrees[in]++;
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegrees[i] == 0){
                q.add(i);
                count++;
            }
        }

        if(count == numCourses) return true;
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
			//get dependencies for the node and decrement it's value in inDegree array.
			// If it becomes zero ==> node has become independant - add to the queue
            List<Integer> dependencies = map.get(curr);
            if(dependencies != null){
                for(int dependency: dependencies){
                    inDegrees[dependency]--;
                    if(inDegrees[dependency] == 0){
                        q.add(dependency);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}