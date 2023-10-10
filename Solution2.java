// Leetcode Problem : https://leetcode.com/problems/course-schedule/description/
// Time Complexity : O(v+e)
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Step 1 : Create adjacency list in the form of hashmap and indegrees array.
 * Step 2 : Add all nodes whose indegrees = 0 to queue and increment courses by 1 for each node that satisfies the condition. If courses = 0, return false.
 * Step 3 : Perform BFS - go to each node in queue and decrement the indegrees of the nodes that it leads to. If indegree of any node becomes 0, add it to queue and increment courses. Repeat this till queue is empty.
 * Step 4 : Return if courses==numCourses.
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int []indegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int courses=0;
        for(int []temp : prerequisites)
        {
            indegree[temp[0]]++;
            if(!map.containsKey(temp[1]))
            {
                map.put(temp[1],new ArrayList<>());
            }
            map.get(temp[1]).add(temp[0]);
        }
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
                courses++;
            }
        }
        if(courses==0)
        {
            return false;
        }
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                int temp = q.poll();
                List<Integer> adjList = map.get(temp);
                if(adjList!=null)
                {
                    for(int node : adjList)
                    {
                        indegree[node]--;
                        if(indegree[node]==0)
                        {
                            q.add(node);
                            courses++;
                        }
                    }
                }
            }
        }
        return courses==numCourses;

    }
}