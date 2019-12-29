// Time Complexity - O(V+E)
// Space Complexity - O(V+E)
// This solution worked on LeetCode
// In this problem, 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         Queue<Integer> q = new LinkedList<>();
        // build the indegrees and hashmap
        int[] indegrees = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][1]]++;
            if(!map.containsKey(prerequisites[i][0]))
                map.put(prerequisites[i][0],new ArrayList<>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        // Use the hashmap and indegrees to contruct the BFS
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i] == 0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> children = map.get(course);
            if(children != null){a
                for(int child : children){
                    indegrees[child]--;
                    if(indegrees[child]==0){
                        q.add(child);
                    }
                }   
            }
            
        }
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i] != 0)
                return false;
        }
        return true;
        
    }
}
