// Time Complexity : O(N)N=number of courses to complete in matrix of size N X M . 
// Space Complexity : O(N) because we use extra data structure for inDegree array and graph
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the first step is to create inDegree array and graph.  Second step is prepare queue(BFS) with elements witn inDegree 0(root). The last 
// step is to use bfs to get children and process the graph and inDegree array. if an element in the indegree array becomes 0 we add it to 
// queue in order to process its children.
// and the ende we process indegree array, if all elements ara 0 we return true, otherwise false;
//Success
//Details 
//Runtime: 15 ms, faster than 36.14% of Java online submissions for Course Schedule.
//Memory Usage: 46.2 MB, less than 60.00% of Java online submissions for Course Schedule.
 public boolean canFinish(int numCourses, int[][] prerequisites) {
       int[] inDegree=new int[numCourses];
	   
	   //Prepare graph and inDegree array of courses;
       Map<Integer,List<Integer>> graph= new HashMap<>();
       for (int i=0;i<prerequisites.length;i++){
         inDegree[prerequisites[i][0]]++;
         if (!graph.containsKey(prerequisites[i][1])){
           graph.put(prerequisites[i][1],new ArrayList<>());
         }
         graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
       }
	   //prepare queue used in BFS.
       Queue<Integer> queue= new LinkedList<>();
       for (int i=0;i<inDegree.length;i++){
          if (inDegree[i]==0)
              queue.add(i);
       }
	   if (queue.isEmpty())
		   return false;

	   //process graph with BFS
       while (!queue.isEmpty()){
         int course= queue.poll();
         List<Integer> children= graph.get(course);
         if (children!=null){
             for (int child:children){
                 inDegree[child]--;
                 if (inDegree[child]==0)
                     queue.add(child);
             }
         }
       }

	   //check all elements are 0. 
       for (int i=0;i<inDegree.length;i++){
           if (inDegree[i]>0)
               return false;
       }
       return true;   
    }
}