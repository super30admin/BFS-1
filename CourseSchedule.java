// Time Complexity : O(numCourses + Edges) 
// Space Complexity : O(numCourses + Edges) = O(numCourses) since we are maintaining a HashMap as adjacency list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  indegree Pattern was difficult to come up with
/* Your code here along with comments explaining your approach: Model the list of prerequisites data into a graphical form in form of a adjacency list
that represents the dependencies. Maintain an indegree array to store the count of the incoming edges of the nodes => indegree. Start with the node
having an indegree 0 => independent course we can start off with. Process the queue with indegrees 0, and decrement the respective connections
of that node having indegree 0 with its neighbors because we have already done the prerequisite and hence the current node is not a dependency anymore
for its neighbors. If the indegree becomes 0, add it to the queue as thats the next course to be done. At the end, if the indegree array has any
value > 0 => the course cant be completed since its not independent. Elsewise its true. */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0){return true;}     // Base case
        HashMap<Integer, List<Integer>> adjList = buildAdjacency(numCourses, prerequisites);            // Getting the Adjacency List for O(1) fetch
        int[] indegree = new int[numCourses];                       // Storing the indegrees
        Queue<Integer> queue = new LinkedList<>();                      // BFS
        for(int i  = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;                                    // Increment the indegrees of the nodes    O(Edges)
        }
        for(int j = 0; j < indegree.length;j++){
            if(indegree[j] == 0){                                               // Start processing the independent course first  O(Vertices)
                queue.add(j);
            }
        }
        while(!queue.isEmpty()){                                                 // O(V + E)   
            int key = queue.poll();
            if(adjList.containsKey(key)){                                         // Fetching the neighbors of the considered node
                List<Integer> temp = adjList.get(key);
                for(int k  = 0 ; k < temp.size();k++){                          
                    indegree[temp.get(k)]--;                                    // Decrement the indegree as the node has been processed already, so neighbors are not dependent on it anymore
                    if(indegree[temp.get(k)] == 0){
                        queue.add(temp.get(k));                                 // Add to the queue, if indegree is 0 as it became independent
                    }
                }
            }
        }
        for(int i = 0; i <indegree.length ; i++){                               // O(Vertices)
            if(indegree[i] != 0){                                               // Return false if indegree is not 0 in the array for anyone
                return false;
            }
        }
        
        return true;
    }
    private  HashMap<Integer, List<Integer>> buildAdjacency(int n, int[][] preList){                // O(Edges)
         HashMap<Integer, List<Integer>> courseMap  = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < n;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < preList.length;j++){
                if(preList[j][1] == i){                                         // Creating the Adjacency list 
                temp.add(preList[j][0]);
                courseMap.put(i, temp);                                         // node with its neighbors
                } 
            }
        }
        return courseMap;
    }
}