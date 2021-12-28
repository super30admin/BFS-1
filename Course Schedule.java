// Time Complexity : O(V+E)// vertices + edges //O(max(V,E))
// Space Complexity : O(V+E)+O(V)+O(V)(hashmap - adjacency list, BFS queue no. of vertices, indegrees
//array respectively) --> O(V+E)(higher order term)
// Did this code successfully run on Leetcode 207:yes
/*Approach - anytime we will start pushing the values into the queue that are independent here the course 0 is
independent(that is it does not have any prerequisite)*/


class Solution {
    HashMap<Integer,List<Integer>> hm;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int courses=0;
        if(numCourses == 0)
            return true;
        hm=new HashMap<>();
        int[] inedges=new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        for(int[] edge:prerequisites){
            inedges[edge[0]]++;
            if(!hm.containsKey(edge[1]))
                hm.put(edge[1],new ArrayList<>());
            hm.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<inedges.length;i++)
        {
            if(inedges[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            if(hm.get(curr)!=null){
            for(int edge:hm.get(curr))
            {
                inedges[edge]--;
                if(inedges[edge]==0)
                    q.add(edge);
            }
        }
            courses++;
        }

        return (courses==numCourses);
    }
}