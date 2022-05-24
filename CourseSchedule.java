//Time Complexity: O(V+E) Space: O(V)+O(V+E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        int[] indegrees = new int[numCourses];
        // adjacency list - independant nodes with neighbouring dependant nodes
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        // creating adjacency list for traversing on the dependancies later, also keeping track of no of dependancies on every course
        for(int[] prerequisite: prerequisites){ // O(E)
            indegrees[prerequisite[0]]++;
            if(!adjList.containsKey(prerequisite[1]))
                adjList.put(prerequisite[1], new ArrayList<>());
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> que = new LinkedList<>();
        int count = 0;
        //pushing independant nodes to queue for processing
        for(int i=0;i<indegrees.length;i++) { //O(V)
            if(indegrees[i] == 0) {
                que.add(i);
                count++;
            }
        }
        if(que.isEmpty()) return false;
        System.out.println(adjList);
        while(!que.isEmpty()) { //O(V+E)
            int independantNode = que.poll();
            List<Integer> adjLi = adjList.get(independantNode);
            // only if there's some dependancy, we traverse
            // else we skip, as independant courses are already counted in previous loop
            if(adjLi != null) {
                for(int dependantNode: adjLi) {
                    indegrees[dependantNode]--;
                    if(indegrees[dependantNode] == 0) {
                        que.add(dependantNode);
                        count++;
                        if(count == numCourses) return true;
                    }
                }}
        }
        return false;
    }
}