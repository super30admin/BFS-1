// Time Complexity : O(V+E)
// Space complexity: O(V+E) 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i < prerequisites.length; i++){
            // form the indegrees array
            indegrees[prerequisites[i][0]]++;
            
            // form the graph hashmap
            if(!graph.containsKey(prerequisites[i][1])){ // if the node is not in the hashmap
                graph.put(prerequisites[i][1], new ArrayList<>());
            }            
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);            
        }
        
        //forming my course queue
        Queue<Integer> q = new LinkedList<>();
        
        // adding courses that have an indegree 0 (i.e, no dependency) to my course queue
        for(int i = 0; i<indegrees.length; i++ ){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        
        //processing the queue to see if it's possible to finish all courses
        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> children = graph.get(course);
            if(children != null){
                for(int child: children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                    }
                }                
            }
        }
        for(int i = 0; i<indegrees.length; i++ ){
            if(indegrees[i] > 0) return false;
        }        
        return true;
    }
}
