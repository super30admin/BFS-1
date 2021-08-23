
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Yes for bulding a graph




// Your code here along with comments explaining your approach
/*Approach
1) Every list in lists, the list[1] contains the current course and list[0] contains prerequisite course
2) Thus, we need to construct a graph, as we know we can complete the course 1 if we have taken complete the course 2. 
3) thus to do this, we need a graph. 
4) then we check for indegree, thus we go for a BFS approach. Thus we put the course as starting point of bfs which has no indgeree (i.e means no dependency)
5) Thus we peform BFS and as we travel through the egde and reduce the indegree subsequently. if we cannot complete all the edges, we come across a cycle.
6) thus in the end we return count == numCourses, if that is true we have travelled through all the edges. if false, we come acroos a cycle
7) this is an example of topological sort.
*/


class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(prerequisites.length==0 || prerequisites==null)
        {
            return true;
        }
        
        int[] indegree = new int[numCourses];
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int[] edge: prerequisites)
        {
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1],new ArrayList());
            }
            
            map.get(edge[1]).add(edge[0]);
            
        } 
        
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                queue.add(i);
            }
            
        }
        
        if(queue.size()==0)
        {
            return false;
        }
        
        
        int count =0;
        
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            count++;
            List<Integer> edges = map.get(curr);
            if(edges!=null)
            {
                for(int edge : edges)
                {
                    indegree[edge]--;
                    if(indegree[edge]==0)
                    {
                        queue.add(edge);
                    }
                }
            }
        }
        
        return count==numCourses;
    }
}