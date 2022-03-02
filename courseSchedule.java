/**

numCourses =3
prerequisites = [[1,0],[0,1]]

[ai, bi] must take bi before ai.

1 -> 0
0 -> 2

        0
    1       2
    
    TC - O(V) + O(E) 
    SC - O(V+E)
**/
class Solution {
    
    // graph 
    Map<Integer, List<Integer>> graph;
    
    int completedCourses;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        graph = new HashMap<>();
        
        
        for (int i=0; i<numCourses; i++)
        {
            graph.put(i, new ArrayList<>());
        }
        
        for (int pre[] : prerequisites)
        {
            graph.get(pre[0]).add(pre[1]);
        }
        
        completedCourses = 0;
        
        boolean visited[] = new boolean[numCourses];
        
        for (int i=0; i<numCourses; i++)
        {
            if (canFinishHelper(visited, new boolean[numCourses], i))
            {
                return false;
            }
        }
        
        return completedCourses == numCourses;
    }
    
    private boolean canFinishHelper(boolean visitedCourse[], boolean trackRecursiveStack[], int course)
    {
        // This means it contains a cycle and we can not finish the courses 
        if (trackRecursiveStack[course])
        {
            return true;
        }
        
        if (visitedCourse[course])
        {
            return false;
        }
        
        // process the course
        visitedCourse[course] = true;
        trackRecursiveStack[course] = true;
        
        // traverse all the neighbours and call recursion on that
        for (int n : graph.get(course))
        {
            if (canFinishHelper(visitedCourse, trackRecursiveStack, n))
            {
                return true;
            }
        }
        
        completedCourses++;
        
        // backtrack 
        trackRecursiveStack[course] = false;
        
        return false;
    }
}
