//# Problem 2
//Course Schedule (https://leetcode.com/problems/course-schedule/)

// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        // Count in-degrees
        // Create a dependent course adjacency list
        List<Integer>[] adjList=new ArrayList[numCourses];
        for(int[] prereq: prerequisites){
            //prereq[1] te prereq[0] paana hai
            if(adjList[prereq[1]]==null){
                adjList[prereq[1]]=new ArrayList<>();
            }
            adjList[prereq[1]].add(prereq[0]);

            // add to indegree array
            inDegree[prereq[0]]++;
        }

        // Topological sort
        Queue<Integer> q=new LinkedList<>();
        // Push all nodes with in-degrees zero
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        // If no nodes with in-degree zero
        if(q.size()==0){
            return false;
        }

        while(!q.isEmpty()){
            int curr=q.poll();
            List<Integer> children = adjList[curr];

            // Process current node
            // Reduce in-degrees of all children
            if(children==null)  continue;
            for(int i=0;i<children.size();i++){
                int currChild=children.get(i);

                inDegree[currChild]--;
                if(inDegree[currChild]==0){
                    // if in-degree for a child is zero
                    q.add(currChild);
                }
            }
        }

        // Count number of nodes with non-zero in-degree
        // if none, then all courses can be taken
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]!=0){
                return false;
            }
        }

        return true;
    }
}