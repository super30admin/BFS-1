import java.util.*;
//TC: To build HashMap , we took O(E), where E - edges in the graph.
//In the Queue, we visited Edge + Vertex. Hence, TC = O(2.E + V) = O(E+V)

//SC: Indegree array has O(V)
//HashMap has O(V + E). Hence, SC = O(2.V + E) = O(E + V)

//We use the method od topological sort for a Directed Acyclic Graph. For every directed edge uv, vertex u comes before v. 
//We generate indegree array to find the node that has no prereqs. HashMap to map courses with their prereqs.
//Start DFS with a node without prereqs and follow the edges. Decrement the degree of vertices once we follow the edge. 
//With this, more nodes without prereqs will occur. It terminates when there are no edges to remove.
//If it is a DAG, the count will be equal to numCourses, else there must be a cycle in the graph and cause a deadlock. 

public class ScheduleCourses {
    
    public static boolean scheduleCourses(int numCourses, int[][] prereqs){

        //indegree array and HashMap generation

        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge : prereqs){
            int start = edge[1], end = edge[0];
            indegree[end]++;
            if(!map.containsKey(start))
                map.put(start, new ArrayList<>());
            map.get(start).add(end);
        }

        //Topological Sort

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }

        int count = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            if(map.containsKey(course)){
                for(int child : map.get(course)){
                    if(--indegree[child] == 0){
                        q.offer(child);
                    }
                }
            }
            count++;  
        }
        return count == numCourses;
    }

    public static void main(String[] args){
        int[][] prereqs = {{2,0}, {4,0}, {1,2}, {1,4}, {3,2}, {5,3}, {1,5}};
        //{{1,0}, {0,1}};
        
        System.out.println(scheduleCourses(6, prereqs));
    }
}
