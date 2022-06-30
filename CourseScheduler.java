/*
This solution uses a BFS approach to solve the problem. We visualize the problem as a directed graph, and consider the 
prerequisites to be dependencies/edges of that graph. For each node(course) in this graph, the number of prereqs is equal
to the indegree at that node. We will then calculate the indegrees of all the nodes, and also create a map of all the 
dependencies between the nodes. For each course, we check it's dependencies, and which nodes are dependent on it as well.
Accordingly, we will select nodes with no dependencies, and as we select them, we will reduce the indegrees of its dependent 
nodes as well. This will be done over all the nodes of the graph. 

Did this code run on Leetcode: Yes
*/
class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        
        int [] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //calculating indegrees of each node, as well as creating the dependency map
        for(int edge [] : prerequisites)
        {
            indegrees[edge[0]]++;
            
            if(!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList<>());
            
            map.get(edge[1]).add(edge[0]);
        }
        //We use a queue data structure for the BFS traversal
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        for(int i = 0; i < numCourses; i++)
        {    //Initially we add all the nodes with indegree 0 in the queue, signifying that we have taken that course
            if(indegrees[i] == 0)
            {
                q.add(i);
                count++;
            }
        }
        
       while(!q.isEmpty())
       {
           int curr = q.poll();
           List<Integer> li = map.get(curr);
           if(li != null)
           {    
               //As we pop nodes from the queue, we check which nodes were dependent on them, and reduce their indegrees
               for(int edge: li)
               {
                   indegrees[edge]--;
                   //Whenever the indegree of any node reaches 0, we add it to the queue
                   if(indegrees[edge] == 0)
                   {
                       q.add(edge);
                       count++;
                       //We maintain a count variable to check if all the courses were succesfully traversed or not
                       if(count == numCourses)
                           return true;
                   }
               }
           }
       }
        return false;
    }
}