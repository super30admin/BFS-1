class CourseSchedule {
    
    // Time Complexity:    O(V+E) 
    //     O(V) - Each Vertex is traversed (worst-case all vertices has pre-reqs)
    //     O(E) ==> Each edge (Key-->Value) in graph(hashmap) is traversed
    // Space Complexity:   O(n)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(numCourses == 0)
            return true;
        
        // 1. incomingEdges ==> keeps track of incoming edges ==> figure out starting point
        int[] incomingEdges = new int[numCourses.length];
        
        // 2. Constructing the graph and incomingEdges[]
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : prerequisites){
            int first = edge[0];
            int second = edge[1];
            
            incomingedges[first]++; 
            
            if(!graph.contains(second)){
                graph.put(second,new Arraylist());
            }
            graph.get(second).add(first);
        }
        
        // **Topological Sort**      (incomingEdges ==> level-wise starting nodes ==> cycles detection)
        
        // 3. Queue to add all starting nodes(where incomingEdges is 0) at each level
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < incomingEdges.length; i++){
            if(incomingEdges[i] == 0){
                q.add(i);
            }
        }
        
        if(q.isEmpty())     // implies no starting point ==> cycles ==> false
            return false;
        
        while(!q.isEmpty()){
            int front = q.poll();
            if(graph.contains(front)){
                for(x : graph.contains(front)){
                    incomingEdges[x]--;
                    if(incomingEdges[x] == 0)
                        q.add(x);
                }
            }
            // If Graph doesn't contain the pre-req ==> no dependent ==> can moving to next course
        }
        
        // Check for cycles 
        for(int x : incomingEdges){
            if(x != 0)
                return false;   // cycle detected [0,0,0,1,0]
        }
        
        return true;
    }
}