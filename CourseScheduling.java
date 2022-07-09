class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     
        /*
         
         *
         *
        /
        

        
        /*
         * We need to identify the node where to start BFS
         * BFS should be started from the course which doesn't require any prerequisites
         * i.e from any node whose indegree is 0
         * Time complexity : O(V+E)
         */

                
        //Prerequisites is list of edges.
        //numCourses is no of vertices.
        
        if(prerequisites == null || prerequisites.length() == 0)
            return true;
        
        int[] indegrees = new int[numCourses];
        
        /*
         * Adjacency List is map of  Independent courses  to dependant courses
         *
         */
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int [] edge : prerequisites) { O(no.of edges)
            
            // edge[0] is dependent on edge[1]   
            // So Incrementing indegree array at index edge[0], 
            indegrees[edge[0]]++;
            
            if(!adjList.containsKey(edge[1])) {
                adjList.put(edge[1], new ArrayList<Integer>());
            }
            
            // Adjacency list is Independent edges -> Dependant edges
            adjList.get(edge[1]).add(edge[0]);
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        
        // For tracking no of completed courses.
        int count = 0;        
        
        // Check if any indegree for any course is 0 and start BFS from there
        for(int i=0; i < indegrees.length; i++) { //O(no.of vertices)
            
            if(indegrees[i] == 0) {
                q.add(i);
                count++;
                if(count == numCourses) {
                        return true;
                    }
            }
        }
        
        if(q.isEmpty()) return false;
        
        System.out.println("indegrees:");    
        for(int j =0; j < indegrees.length; j++) {
            System.out.println(indegrees[j]);    
        }
        
        System.out.println("Adj List");    
        adjList.entrySet().forEach(entry -> {
    System.out.println(entry.getKey() + " " + entry.getValue());
    });
    
        while(!q.isEmpty()) { //O(V+E)
            
            int currNode = q.poll();
            
            // Get child nodes of current node in the adj list
            List<Integer> children = adjList.get(currNode);
            
            // Since the current course is completed all the children indegree associated with 
            // current node can be decremented by 1
            if(children != null) {
            
            for(int child: children) {
                
                // Decrement indegree array
                indegrees[child]--;
                
                // After decrementing if that particualr child indegree becomes 0, 
                //that node can be added to quque
                    if(indegrees[child] == 0) {
                        q.add(child);
                        count++;
                        // For each node added to Queue check if all courses are completed.
                        if(count == numCourses) return true;
                    }
                }
            }             
        }
        
        return false;        
    }
}
