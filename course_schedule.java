import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author aupadhye
 *
 */

//Time complexity is O(n^2) since we iterate through each node and check for other node routes.
//Space complexity is O(n) since we maintain auxiliary arrays for maintaining visited notes.
public class course_schedule {

	/**
	 * @param args
	 */
	
	public static  boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1]; // Prerequsite is the first entry and zeroeth entry is the course 
            int child = prerequisites[i][0];
            if (graph.containsKey(parent)) //If the pre req is there , then add it to the child.
                graph.get(parent).add(child);
            else {
                List<Integer> adj = new ArrayList<Integer>();
                adj.add(child);
                graph.put(parent, adj);
            }
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses]; // Maintain two boolean arrays for checking visit and if the elements are in stack or not 
        
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int key = entry.getKey();
            if (isCyclic(key, graph, visited, inStack)) { //Check if the graph formed is cycle or not
                return false;//Topological sort wont work on cyclic graphs, so return false;
            }
        }
        return true;
    }
    
    private static  boolean isCyclic(int key, HashMap<Integer, List<Integer>> graph, boolean[] visited, boolean[] inStack) {
        if (inStack[key] == true)
            return true;
        if (visited[key] == true)
            return false;
        visited[key] = true;
        inStack[key] = true;
        if (graph.containsKey(key)) {
            List<Integer> adj = graph.get(key);
            for (int i = 0; i < adj.size(); i++)
                if (isCyclic(adj.get(i), graph, visited, inStack)) // Check for all the adjacent vertices from that key if the vertices are visited or not 
                    return true;
        }
        inStack[key] = false;
        return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[][] prerequisites = new int[][] {{1,0},{0,1}};
		int num = 2;
		System.out.println(canFinish(num,prerequisites));
		
	}

}
