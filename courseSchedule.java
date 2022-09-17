// TC : O(V+E)
// SC : O(n)
// Ran on LC : Yes
// Problems : None.
class Solution {
	public boolean canFinish(int numCourses, int[][] edges) {
		 HashMap<Integer, List<Integer>> map = new HashMap<>();
		 int[] indegrees = new int[numCourses];
		 
		 for(int[] edge : edges) {
			  indegrees[edge[0]]++;
			  if(!map.containsKey(edge[1])) {
					map.put(edge[1], new ArrayList<>());
			  }
			  map.get(edge[1]).add(edge[0]);
		 }
		 
		 //BFS
		 Queue<Integer> q = new LinkedList<>();
		 
		 int count = 0;
		 
		 for(int i = 0; i < numCourses; i++) {
			  if(indegrees[i] == 0) {
					q.add(i);
					count++;
			  }
		 }
		 
		 if(count == numCourses) return true;
		 
		 while(!q.isEmpty()) {
			  int curr = q.poll();
			  List<Integer> children = map.get(curr);
			  if(children != null) {
					for(int child : children) {
						 indegrees[child]--;
						 if(indegrees[child] == 0) {
							  q.add(child);
							  count++;
							  if(count == numCourses) return true;
						 }
					}
			  }
		 }
		 
		 return false;
	}
}