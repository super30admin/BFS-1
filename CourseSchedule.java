// Time Complexity: O(V+E) 
// Space Complexity: O(V+E)

// Approach
// We know this is a graph problem by drawing out the edges and the vertices. We approach using DFS.
// We have a matrix with matrix[0] is the course and matrix[1] is the prereq of it. We draw the graph with the 
// edges as the dependencies and the vertices are the number of Courses required to be taken.
// We need to create an indegree array i.e.the frequency of each course. 
// We also need an adjacency list using a hashmap to have mapping of pre-req : courses
// We first create the indegree array by going over the pre-req matrix and increment the indegree of a node by 1
// At the same time we add these nodes to the hashmap with the key as the independent node and the value as the arraylist of dependent nodes
// We need to keep a count, so that when indegree of any course becomes 0, we add it to that count. Because in the end, 
// We have to check if count==numCourses
// Next, we need a queue to process each node whos indegree is 0 meaning the nodes which are independent
// First we increment count by going over already independent nodes and adding them to the queue.
// Then we process the elements in the queue by polling the current independent node and getting its corresponding array list
// of dependent nodes from the adjacency list (children)
// We iterate over these children and decrement their indegrees and also add it to the queue until the queue is empty
// In the above we also check if the indegree has reached 0 of that node and increment the count
// After the while loop ends return true if numCourses==count else return false
// Base conditions: we check if children are null or not, queue is empty after we tried to add already independent nodes


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Create adjacency list
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        // Create indegrees array
        int[] indegrees=new int[numCourses];
        
        //Iterate over prereq matrix, get the indepe and dependent nodes
        for(int [] edge:prerequisites){
            int dependent=edge[0];
            int indepe=edge[1];
            
            // Increment indegree of dependent nodes, basically the actual courses, not prereqs
            indegrees[dependent]++;
            
            // if map doesnt contain indepe, create new arr list
            if(!map.containsKey(indepe)){
                map.put(indepe, new ArrayList<>());
            }
            
            // add dependent to arr list
            map.get(indepe).add(dependent);
        }
        
        // Create queue to process node which becomes independent
        Queue<Integer> q = new LinkedList<>();
    
        
        //Keep a counter
        int count=0;
        
        //First we add the already independent nodes
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0) // ONLY NODES WITH 0 INDEGREE GO INTO THE QUEUE/INDEPE NODES
            {
                q.add(i); // add to queue
                count++; //increment conunt
            }
        }
        
        // If there are no dependent nodes i.e. it is a cycle
        if(q.isEmpty()) return false;
        
        // Process independent nodes in queue
        while(!q.isEmpty()){
            
            int course=q.poll(); // The prerequisite
            
            List<Integer> children = map.get(course); //get the dependent courses from adjacency list into an array
            
            if(children!=null){ //null check, it could be a course as no prereq {[key]:[]}
                
                //process dependent courses, and reduce their indegree
                for(int child: children){
                    indegrees[child]--;
                    if(indegrees[child]==0)
                    {
                        q.add(child); //remember we only add indepe to the queue/ courses whose indegree is 0
                        count++;
                    }
                }
            }
        }
        if(numCourses==count) return true;
        return false;
    }
    
}