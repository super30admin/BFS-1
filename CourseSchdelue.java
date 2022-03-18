//time complexity: O(log V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach: Create an adjacency list and indegree array. Add the nodes with indegree as
// 0 to the queue. Every time we complete a course, we pop that node from queue, check the
//  adjacency list and find the dependent courses. For those dependents, we reduce the indegree
// value and update them to the queue if their indegree is 0. I

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] prereq : prerequisites)
        {
            int dependent = prereq[0];

            int source =  prereq[1];
            if(!adjList.containsKey(source))
            {
                adjList.put(source, new ArrayList<>());

            }
            adjList.get(source).add(dependent);
            ++indegree[dependent];
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i =0 ; i<numCourses; ++i)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        int completedCourses = 0;

        while(!q.isEmpty())
        {
            int course = q.remove();
            ++completedCourses;

            List<Integer> dependents = adjList.get(course);
            if (dependents != null)
            {
                for (int dependent : dependents)
                {
                    --indegree[dependent];
                    if(indegree[dependent] == 0)
                    {
                        q.add(dependent);
                    }
                }
            }

        }
        return completedCourses == numCourses;
    }
}