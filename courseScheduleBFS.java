// Time Complexity: O(V+E)
// Space Complexity: O(V+E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        // Create indegrees array and adjacency list
        for(int[] prerequisite: prerequisites){
            int child = prerequisite[0];
            int parent = prerequisite[1];
            indegrees[child]++;
            if(!map.containsKey(parent)){
                map.put(parent, new ArrayList<>());
            }
            map.get(parent).add(child);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        // Add independent courses to Queue
        for(int i=0; i< indegrees.length; i++){
            if(indegrees[i] == 0)   q.add(i);
        }
        
        // Parse over elements in Q to see if we are able to take all courses
        int count = 0;
        while(!q.isEmpty()){
            // parent being taken
            int parent = q.poll();
            count++;
            
            // parent is taken. reduce dependencies on child
            List<Integer> childs = map.get(parent);
            if(childs != null){
                for(int child: childs){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                    }
                }
            }
        }
        
        if(count != numCourses) return false;
        return true;
    }
}