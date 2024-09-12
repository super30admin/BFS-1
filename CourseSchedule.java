// Time Complexity : O(N)
// Space Complexity : O(N)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        // 0: []
        // 1: []
        // 2: []
        for(int i = 0; i < numCourses; i++) {
        	graph.put(i, new LinkedList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] tuple: prerequisites) {
        	// tuple [course, prerequisite]
        	// prerequisites --> course
        	int course = tuple[0];
        	int prerequisite = tuple[1];

        	graph.get(prerequisite).add(course);
        	indegree[course]++;
        }

        // topological sort
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
        	if(indegree[i] == 0) {
        		queue.add(i);
        	}
        }

        int count = 0;

        while(!queue.isEmpty()) {
        	int currentCourse = queue.poll();
        	List<Integer> correspondingCourses = graph.get(currentCourse);
        	for(int course: correspondingCourses) {
        		indegree[course]--;
        		if(indegree[course] == 0) {
        			queue.add(course);
        		}
        	}
        	count++;
        }

        if(count == numCourses) return true;
        return false;
    }
}