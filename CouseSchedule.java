// Time Complexity: O(V + E) where V = number of courses and E = number of pre-req
// Space Complexity: O(V + E) 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
         int n = prerequisites.length;
        for(int i = 0; i < n; i++){
            int ind = prerequisites[i][1];
            int dep = prerequisites[i][0];
            indegrees[dep]++;

            if(!map.containsKey(ind)){
                map.put(ind, new ArrayList<>());
            }
            map.get(ind).add(dep);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                queue.add(i);
                count++;
            }
        }
        if(count == numCourses){
            return true;
        }
        if(queue.isEmpty()){
            return false;
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();

            if(!map.containsKey(curr)){
                continue;
            }
            List<Integer> children = map.get(curr);
            for(Integer child: children){
                indegrees[child]--;

                if(indegrees[child] == 0){
                    queue.add(child);
                    count++;

                    if(count == numCourses){
                        return true;
                    }
                }
            }
        }
        return false;


    }
}