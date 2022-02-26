import java.util.*;

/*
Time Complexity:O(v+e)
Space Complexity: O(n)
Run on leetcode: yes
Any difficulties: no

Approach:
1. Finding out a cycle in the graph, is cycle is there, there is no chance to complete the courses
2. It should be directed acyclic graph
 */
public class CourseSchedule {
    public static boolean courseSchedule(int[][] prerequisites, int numCourses ){
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for(int[] prereq: prerequisites){
            int source = prereq[1];
            int destination = prereq[0];
            List<Integer> list = adjacencyList.getOrDefault(source, new ArrayList<>());
            list.add(destination);
            adjacencyList.put(source, list);
            indegree[destination]++;
        }
        int count = 0;

        for(int i = 0; i<indegree.length; i++){
            if(indegree[i]== 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.remove();
            count++;
            if(adjacencyList.containsKey(node)){
                for(int neighbor: adjacencyList.get(node)){
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 0){
                        queue.add(neighbor);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args){
        int[][] prerequisites = {{1,0}, {0,1}};
        System.out.println(courseSchedule(prerequisites,2));
    }
}
