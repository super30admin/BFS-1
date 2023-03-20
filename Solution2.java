// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I calculate the indegrees of each node and create an adjacency list in the form of a hash map. I maintain count to keep track of number
 * of nodes that have entered the queue. At first, I add all nodes with indegree = 0 to the queue. Now I iterate till queue is not empty.
 * I pop nodes from the queue and decrement indegrees of all the nodes to which it has a link. If indegrees of any of the node becomes 0, I add
 * it to the queue and increment count. At the end, if count==numCourses, I return true, else I return false.
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int []indegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int []temp : prerequisites)
        {
            indegree[temp[0]]++;
            if(!map.containsKey(temp[1]))
            {
                map.put(temp[1],new ArrayList<Integer>());
            }
            map.get(temp[1]).add(temp[0]);
        }
        int count=0;
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                count++;
                q.add(i);
            }
        }
        if(count==0)
        {
            return false;
        }
        while(!q.isEmpty())
        {
            int node = q.poll();
            List<Integer> temp = map.get(node);
            if(temp!=null)
            {
                for(int tempNode : temp)
                {
                    indegree[tempNode]--;
                    if(indegree[tempNode]==0)
                    {
                        q.add(tempNode);
                        count++;
                    }
                }
            }
        }
        return count==numCourses;
    }
}