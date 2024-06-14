// Time Complexity : O(V+E) - V : courses, E - length of prerequisites
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// fill hashmap and indeg array
// get course which is independent and add it to the queue
// iterate over hashmap and update queue and indeg array 
//return false if all the indeg array id not zero 
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            return true;s
        }

        Queue <Integer> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int [] indeg = new int[numCourses];
        int count = 0;

        // fill hashmap and indeg array
        for(int[] prerequisite : prerequisites){
            int from = prerequisite[1];
            int to = prerequisite[0];
            indeg[to]++; 
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }    

        // get course which is independent and add it to the queue
        for(int i = 0; i<numCourses; i++){
            if(indeg[i] == 0){
                q.add(i); //*
                count++;
            }
        }
        // iterate over hashmap and update queue and indeg array 
        while(!q.isEmpty()){
            int curr = q.poll();
            if(!map.containsKey(curr)){
                continue;
            }
            List<Integer> edges = map.get(curr);
            if(edges == null){
                continue;
            }
            for (int edge : edges){
                indeg[edge]--;
                if(indeg[edge] == 0){
                    q.add(edge);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}