//Time complexity = O(V + E) V is number of node and E number of edges in the graph
//Space complexity = O(V + E)

class Solution {

    //dependencies and ordering required, use topological sort

    //create adjacency list for the graph
    List<List<Integer>> adjacencyList;

    //indegree array
    int[] indegrees;

    //max number of nodes
    int maxn = 100000;

    //initialise the graph from the given input
    public void graph()
    {
        indegrees = new int[maxn];
        adjacencyList = new ArrayList();

        for(int i=0; i<maxn; i++)
        {
            indegrees[i]=0;
            adjacencyList.add(new ArrayList());
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //build empty graph
        graph();

        //put values in the graph
        for(int[] row : prerequisites)
        {
            indegrees[row[0]]++;
            adjacencyList.get(row[1]).add(row[0]);
        }

        //queue for BFS traversal
        Queue<Integer> q = new LinkedList();

        //list of courses taken
        List<Integer> courseOrder = new ArrayList();

        //add all the indegree 0 nodes to queue
        for(int i=0; i<numCourses; i++)
        {
            if(indegrees[i]==0)
                q.add(i);
        }

        while(!q.isEmpty())
        {
            //take a course and add it to resultant list
            int course = q.remove();
            courseOrder.add(course);

            //for that course
            for(int child : adjacencyList.get(course))
            {
                //decrement indegree of course's child
                indegrees[child]--;
                //if any child's indegree becomes 0, add it to queue
                if(indegrees[child] == 0)
                    q.add(child);
            }
        }

        //if in the end all courses have not been taken, return false
        if(courseOrder.size() != numCourses)
            return false;

        return true;

    }
}
