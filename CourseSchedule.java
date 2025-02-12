import java.util.*;

//dfs method
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //if a node is a cycle it cannot be completed
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        //indegree array : a dag graph will only have nodes with one indegree edge
        int[] inDegree = new int[numCourses];

        //create adjacency list
        for(int[] prereq : prerequisites){
            inDegree[prereq[0]]++;
            adjList.get(prereq[1]).add(prereq[0]);
        }


        //queue to keep all the nodes which have only one indegree edge
        Queue<Integer> queueList = new LinkedList<>();
        
        for(int i = 0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                queueList.offer(i);
            }
        }

        int visitedNode  = 0;
        while(!queueList.isEmpty()){
            int node = queueList.poll();
            visitedNode++;
            for(int neighbour : adjList.get(node)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0){
                    queueList.offer(neighbour);
                }
            }
        }

        return visitedNode == numCourses ;

    }
}