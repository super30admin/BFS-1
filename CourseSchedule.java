// Time Complexity: O(n)
// Space Complexity : O(n)

// Kahn's Topological Sort
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null)
            return false;
        
        int inDegree[] = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int [] course : prerequisites)
        {
            inDegree[course[0]]++;
            map.putIfAbsent(course[1], new ArrayList<>());
            map.get(course[1]).add(course[0]);
        }
        
        int visitedCourses = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i ++)
        {
            if(inDegree[i] == 0)
            {
                q.offer(i);
            }
        }
        
        while(!q.isEmpty())
        {
            int course = q.poll();
            visitedCourses++;
            List<Integer> neigh = map.get(course);
            if(neigh != null)
            {
                for(int c : neigh)
                {
                    inDegree[c]--;
                    if(inDegree[c] == 0)
                        q.offer(c);
                }
            }
        }
        
        return visitedCourses == numCourses;
    }
}

// DFS
// Time Complexity: O(n)
// Space Complexity: O(v) + O(v) + O(v) + O(v+e) -> O(v+e)
public class CourseSchedule {
    Map<Integer, List<Integer>> map;
    boolean [] path;
    boolean [] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null)
            return false;
        
        // build adj list
        map = new HashMap<>();
        for(int course[] : prerequisites)
        {
            map.putIfAbsent(course[1], new ArrayList<>());
            map.get(course[1]).add(course[0]);
        }
        
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        
        //start DFS for any one node
        for(int i = 0 ; i < numCourses; i ++)
        {
            if(!visited[i] && hasCycle(i))
                return false;
        }
        
        return true;
    }
    
    private boolean hasCycle(int course)
    {
        // base
        if(path[course]) // same course on current path
            return true;
        if(visited[course]) // already seen
            return false;
        
        // logic
        path[course] = true;
        visited[course] = true;
        
        List<Integer> neigh = map.get(course);
        if(neigh != null)
        {
            for(int next : neigh)
            {
                if(hasCycle(next))
                    return true;
            }
        }
        // backtrack
        path[course] = false;
        return false;
    }
}