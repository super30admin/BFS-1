/* Time Complexity : O(max(V+E))
case 1) Even if every node is dependent on every other node, no.of edges would be equal to length of edges array given in prob - so total edges processed would be just length of egdes array (E - values in AdjacencyMap)
        so its always max(V+E)(every node + total edges processed) , here it will be E that is higher

        case 2) Most of the nodes are independent - then we would be processing more nodes into queue
        Here, it would be keys of AdjacencyMap
        in max(V+E), V is higher

        Space - O(V+E) - []Indegree of length V, queue of max size V and AdjacencyMap of size V+E - so max of everything will be V+E
Space Complexity : O(h)
Did this code successfully run on Leetcode : Yes
*/

import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // []indegrees - to maintain how many nodes is a node dependent on
        //ex: [2,0] - node 2 is dependent on 0th node
        int[] indegrees = new int[numCourses];

        // <>Adjacency list - to maintain <independent node, []list of dependent nodes>
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();

        for(int []edge: prerequisites){
            indegrees[edge[0]]++;
            if(!adjacencyMap.containsKey(edge[1])){
                adjacencyMap.put(edge[1], new ArrayList<>());
            }
            adjacencyMap.get(edge[1]).add(edge[0]);
        }
        //maintain a queue for bfs - store independent nodes at a given time
        Queue<Integer> q = new LinkedList<>();

        int coursesCompleted = 0;

        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == 0){
                //add independent node to queue
                q.add(i);
                coursesCompleted++;
            }
        }

        //optimization 1: if no independent nodes, nothing left to process
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int currNode = q.poll();
            //[]dependent nodes on independent node
            List<Integer> dependentNodes = adjacencyMap.get(currNode);
            if(dependentNodes != null){
                for(int depNode : dependentNodes){
                    //decrease dependency count of nodes
                    //i.e [3,1] , if 1 is completed, 3 s no longer dependent it,
                    //so decrease dependency count of 3

                    indegrees[depNode]--;
                    if(indegrees[depNode] == 0){
                        q.add(depNode);
                        coursesCompleted++;
                    }
                }
            }
        }
        return coursesCompleted == numCourses;
    }

    public static void main(String[] args) {
        System.out.println("Can all the courses be completed? : " + canFinish(2, new int[][]{{1,0}, {0,1}}));
    }
}
