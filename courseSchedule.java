//time complexity: O(V+E)
//space complexity: O(V+E) where V is the number of courses and E is the total number of preReqs

import java.util.*;
class CourseScheduleSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> sorted = new ArrayList<>();
        HashMap<Integer, Integer> inDegree= new HashMap<>();
        HashMap<Integer, List<Integer>> graph=new HashMap<>();
        //initialize 
        for(int i=0; i < numCourses; i++) 
        {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        
        //build graph
        for(int[] preReq: prerequisites)
        {
            inDegree.put(preReq[0], inDegree.get(preReq[0])+1);
            graph.get(preReq[1]).add(preReq[0]);
        }
        
        Queue<Integer> sources = new LinkedList<>();
        //find sources
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet())
        {
            if(entry.getValue()==0)
                sources.add(entry.getKey());
        }
        
        //bfs
        while(!sources.isEmpty())
        {
            int subject=sources.poll();
            List<Integer> children=graph.get(subject);
            sorted.add(subject);
            for(int child: children)
            {
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child)==0)
                    sources.add(child);
            }
        }
        return sorted.size()==numCourses;
    }
}