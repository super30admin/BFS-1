    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/course-schedule/
    Time Complexity for operators : o(V+E) .. number of  verticex+ edges
    Extra Space Complexity for operators : o(V+E) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach same like basic approach:  Iterative.
                              

             approach   
                    A. Count the number of incmoing edges in the given graph.
                    B. Parellely stores the hashmal inorder to retrivee the data in O(1) time.
                    C. Then, in queue all the starting point. Starting point whose value is Zero in incming edges.
                    D. if queue is empty then return false it has circle.
                    E. Now, do BFS, untile queue is empty.  Get childrens from list in HashMap and deduct one from incoming edges and if
                       incoming edges become zero then add it to Queue.
                    F. In the end, traverse thru incpingEdges array and check all become zero or not. If not then return false
                       that means course cannot be completed. s return true.

       */



class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];
        
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        
        // iterate and incoming edges
        for(int[] edges : prerequisites){
            
            int first = edges[0];
            int second = edges[1];
            
            incomingEdges[first] += 1;
            
            if(!hm.containsKey(second)){
                hm.put(second, new ArrayList<>());
            }
            
            hm.get(second).add(first);
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        
        // add all starting points into the queue
        
        for(int i=0;i< incomingEdges.length;i++){
            if(incomingEdges[i] ==0)
                queue.add(i);
        }
        
        if(queue.isEmpty())
            return false;
        
        while(!queue.isEmpty()){
            int front = queue.poll();
            
            // get childrens from list and deduct one from incoming edges and if
            // incoming edges become zero then add it to Queue.
            
            if(hm.containsKey(front)){
                for(int i : hm.get(front)){
                    incomingEdges[i] -= 1;

                    if(incomingEdges[i] == 0)
                        queue.add(i);
                }
            }
        }
        
        for(int i=0;i< incomingEdges.length;i++){
            if(incomingEdges[i] !=0)
                return false;
        }
        
        
        // time coomolpexity = V+E
        // space coomolpexity = V+E
        
        return true;
    }
}