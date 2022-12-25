// Time Complexity : O(v+E)
// Space Complexity :O(v+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Algorithm was tough


// Your code here along with comments explaining your approach

/*
We will create an in degree array of the node, which represents incoming edges to that vertices and in general that would represent the dependency

Once we create the in degree, we will pick up the independant vertice i.e the ones that has no inwards ege i.e 0 count nodes and will reduce the count by one of the vertices that depends on them and then this is how loop condtinues

*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		if(prerequisites.length == 0) return true;  // no prereqs than we can take any number of courses

		// We will convert the edges into adjacency list
		HashMap<Integer,List<Integer>> list = new HashMap<Integer,List<Integer>>();
		
		HashMap<Integer,Integer> indegree = new HashMap<Integer,Integer>(); // we could have taken an array as well


		// Creating the adjacency list
		for(int i=0;i<prerequisites.length;i++){ // O(E)
			// the 1 position vertex is independant
			// the 0 position vertex in dependent
			if(list.get(prerequisites[i][1]) == null){
				list.put(prerequisites[i][1], new ArrayList<Integer>());
			}
			list.get(prerequisites[i][1]).add(prerequisites[i][0]); // we will store that how many vertices are dependant on it
			
			//updating the indegree of dependant
			if(indegree.get(prerequisites[i][0]) == null){
				indegree.put(prerequisites[i][0],0);
			}

			// Since the vertex has a dependency so increasing its count
			indegree.put(prerequisites[i][0],indegree.get(prerequisites[i][0]) +1 );
		}

		

		Queue<Integer> queue = new LinkedList<Integer>();

		int courses = 0; // number of course we can take

		// we will go over the indegree and see whos dependency count is 0
		// we will add all the independant vertex  to the queue
		// Important , the numCourses are the total numCourses, which means the edges would be from 0 to numCourses-1
		// there would be vertex (course) who has no edge, so we can count them as independant in this way 
		// if we start from 0 to numCourses
		for(int vertex =0;vertex<numCourses;vertex++) { // O(V)
			if(indegree.get(vertex) == null || indegree.get(vertex)==0){
				queue.add(vertex);
				courses++; // this means that this many course can be taken without any dependency
			}
		}
		if(courses >= numCourses) return true; // if this is the number of courses needs to be taken, then we are done here

		// we will take each independant vertex out of the queue, reduce the count of indegree of vertex that are dependent on this
		// if any vertex indegree count becomes 0 , we will add into the queue and increase the courses count

		while(!queue.isEmpty()){ // O (E)

			int independantVertex = queue.poll();

			
			if(list.get(independantVertex) == null) continue;
			// go to each dependency and decrease the indegree count
			for(int dependent : list.get(independantVertex)){
				// since the independant vertex is being taken out
				// we will reduce the count of all the vertices and nodes which were dependent on this
				int newCount= indegree.get(dependent);
				newCount--;
				indegree.put(dependent,newCount);
				if(newCount == 0) {
					queue.add(dependent); // since now it become independant , we can add it to our queue
				courses++;// increasing the count of number courses can be taken since it has not any dependencies	
				}

			}
				if(courses >= numCourses){
					return true; // if we reached the required number of courses, then no need to check further
				}
		}

			// if after all the processing, we still did'nt reach the number of courses, then return false
			return false;

    }
}