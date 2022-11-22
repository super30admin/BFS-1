//Time complexity: O(V + E)
//Space complexity: O(V + E)

public class CourseScheduleSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Map for outdegrees lookup
        Map<Integer, List<Integer>> map = new HashMap<>();
        //Create an indegree array
        int[] inDegrees = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            int inDegree = prerequisite[0];
            int outDegree = prerequisite[1];
            inDegrees[inDegree] += 1;
            if(!map.containsKey(outDegree)) {
                map.put(outDegree, new ArrayList<>());
            }
            map.get(outDegree).add(inDegree);
        }

        //Queue data structure for BFS
        Queue<Integer> q = new LinkedList<>();

        int numberOfCourses = 0;
        //Adding courses whose indegrees are zero
        for(int i = 0; i < inDegrees.length; i += 1) {
            if(inDegrees[i] == 0) {
                numberOfCourses += 1;
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if(edges != null) {
                for(Integer edge : edges) {
                    inDegrees[edge] -= 1;
                    if(inDegrees[edge] == 0) {
                        numberOfCourses += 1;
                        q.add(edge);
                    }
                }
            }
        }
        return numberOfCourses == numCourses;
    }
}
