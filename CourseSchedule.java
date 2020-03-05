// Time Complexity : O(n+c) n-> no. of courses; c -> no. of connections
// Space Complexity : O(n); not very sure..in worst case it may be (n-1)(1+2+3+4...n) Please clarify
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach 1: BFS
// The problem here can be formulated as a graph problem wherein each course is the vertex and the dependencies between the courses are the edges.
// In BFS approach, an indegree array can be maintained which will have the respective number of dependencies captured for taking a course.
// All the courses which does not have any dependencies can be added in queue and processed. As and when a course is being processed, the dependecies of the dependent courses can be decreased.
/*
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // edge case check
        if(prerequisites == null || prerequisites.length == 0) return true;
        // create a graph : selecting a set as value to handle duplicate entries
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // create an indegree list to count number of dependencies each course has
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            if(!graph.containsKey(prerequisites[i][1])) {
                graph.put(prerequisites[i][1], new HashSet<>());
            }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //System.out.println(graph);
        // create queue to process courses with 0 dependencies
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int course = queue.poll();
            Set<Integer> set = graph.get(course);
            if(set == null) continue;
            for(int s : set) {
                indegree[s]--;
                if(indegree[s] == 0) queue.offer(s);
            }
        }
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] > 0) return false;
        }
        return true;
    }
}
*/

// Time Complexity : O(n+c) n-> no. of courses; c -> no. of connections
// Space Complexity : O(n); not very sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach 1: DFS - Topological sort
// Topological sort can be implemented by taking two auxiliary datastructures - stack and a set. 
// The set will keep track of the visited nodes whereas the stack will hold the completely explored nodes.
// If at any point of time a cycle is formed, this means that there are interdependencies between the courses and it is not possible to finish all courses.
// The stack will hold the courses in sorted order.
// Topological sort makes sure that the parent nodes are always visited before the dependent nodes.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // edge case check
        if(prerequisites == null || prerequisites.length == 0) return true;
        // create a graph : selecting a set as value to handle duplicate entries
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // create an indegree list to count number of dependencies each course has
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            if(!graph.containsKey(prerequisites[i][1])) {
                graph.put(prerequisites[i][1], new HashSet<>());
            }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //System.out.println(graph);
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        // iterate over all the courses
        for(int course : graph.keySet()) {
            if(!dfs(graph, stack, visited, course)) return false;
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, Set<Integer>> graph, Stack<Integer> stack, Set<Integer> visited, int course) {
        //base case
        // if a node is visited and not completely explored, then it is not possible to finish the course
        if(visited.contains(course) && !stack.contains(course)) return false;
        
        if(!visited.contains(course)) {
            visited.add(course);
            Set<Integer> courses = graph.get(course);
            if(courses != null) {
                // iterate over dependent courses
                for(int c : courses) {
                    if(!dfs(graph, stack, visited, c)) return false;
                }
            }
            stack.add(course);
        }
        return true;
    }
}

