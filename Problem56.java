//Time Complexity: O(n) -> V+E
//Space Complexity: O(n) -> V+E for the map
//Did it run on leetcode: yes
//Problems faced any: No

import java.util.*;

public class Problem56 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //we use topological sorting for this question
        //but since the input is given in arrays format the following steps are required
        //first we will find the incoming edges
        int[] incomingEdges = new int[numCourses];
        //Also a hashmap to keep track of adjacent nodes
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int[] edge: prerequisites){
            //edge[0] -> course
            //edge[1] -> prerequisite
            incomingEdges[edge[0]] += 1;

            //adding adjacent nodes to the list
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }


        //if the incoming edge is zero we can consider it as starting point
        //we will intially add all the starting nodes into the queue
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<incomingEdges.length; i++){
            if(incomingEdges[i]==0)
                queue.add(i);
        }


        while(!queue.isEmpty()){
            int top = queue.poll();
            List<Integer> list = new ArrayList<>();
            if(map.containsKey(top)){
                list = map.get(top);
                for(Integer x : list){
                    incomingEdges[x] -= 1;
                    if(incomingEdges[x]==0)
                        queue.add(x);
                }
            }
        }

        //if all the incoming edges are zero now we can return true else false
        for(int i:incomingEdges){
            if(i!=0)
                return false;
        }

        return true;
    }
}
