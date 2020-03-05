// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i=0; i<numCourses; i++)
            graph.put(i, new LinkedList<>());
        
        int[] inDegree=new int[numCourses];
        
        //[course, prerequisites]
        for(int[] tuple : prerequisites){
            int course=tuple[0];
            int prerequisite=tuple[1];
            
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }
        //topological sorting
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(inDegree[i] == 0)
                q.add(i);
        }
        int count=0;
        
        while(!q.isEmpty())
        {
            int curCourse=q.poll();
            List<Integer> correspondingCourse=graph.get(curCourse);
            for(int course:correspondingCourse)
            {
                inDegree[course]--;
                if(inDegree[course] == 0)
                    q.add(course);
            }
            count++;
            if(count > numCourses)
                return false;
        }
        if(count == numCourses) return true;
        return false;
    }
}