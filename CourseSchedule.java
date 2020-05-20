// Time Complexity : O(V+E) V->vertices, E->Edges
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> mapDependCount = new HashMap<>();
        int takenCourse=0;
        
        for(int[] pre:prerequisites){
            mapDependCount.put(pre[0],mapDependCount.getOrDefault(pre[0],0)+1);
            adjList.computeIfAbsent(pre[1],k->new LinkedList<Integer>()).add(pre[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++)
            if(mapDependCount.getOrDefault(i,0)==0)
                q.add(i);
        
        while(!q.isEmpty()){
            int tmpCourse = q.poll();
            takenCourse++;
            for(int dependCourse:adjList.getOrDefault(tmpCourse, new LinkedList<>()))
            {
                int val = mapDependCount.put(dependCourse,mapDependCount.getOrDefault(dependCourse,0)-1);
                
                if(val==1){
                    q.add(dependCourse);
                }
            }
        }
        
        return takenCourse==numCourses;
    }
}

// Time Complexity : O(V+E)
// Space Complexity : O(V*(V+E)) (Will have V stack calls and each stack will have adjacency list of (V+E))
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english
class Solution {
    
    private int helper(Map<Integer, Integer> mapDependCount, Map<Integer, List<Integer>> adjList, Queue<Integer> q, int takenCourse)     {
        if(q.isEmpty())
            return takenCourse;
        takenCourse++;
        int tmpCourse = q.poll();
            for(int dependCourse:adjList.getOrDefault(tmpCourse, new LinkedList<>()))
            {
                int val = mapDependCount.put(dependCourse,mapDependCount.getOrDefault(dependCourse,0)-1);
                
                if(val==1){
                    q.add(dependCourse);
                }
            }
        
        return helper(mapDependCount, adjList, q, takenCourse);
        
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> mapDependCount = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int takenCourse=0;
        
        for(int[] pre:prerequisites){
            mapDependCount.put(pre[0],mapDependCount.getOrDefault(pre[0],0)+1);
            adjList.computeIfAbsent(pre[1],k->new LinkedList<Integer>()).add(pre[0]);
        }
        
        for(int i=0;i<numCourses;i++)
            if(mapDependCount.getOrDefault(i,0)==0)
                q.add(i);
        return helper(mapDependCount, adjList, q, 0)==numCourses;
    }
}