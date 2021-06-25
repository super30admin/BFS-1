//Time complexity - O(v+e)
//Space complexity - O(v+e)



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      if(prerequisites == null || prerequisites.length == 0) return true;
      int[] indegrees = new int[numCourses];
      //adjacency map (out , in)
      HashMap<Integer, List<Integer>> map = new HashMap<>();
       
      for(int [] prerequisite : prerequisites) {
        int in = prerequisite[0];
        int out = prerequisite[1];
        indegrees[in] ++;
        if(!map.containsKey(out)) {
          map.put(out, new ArrayList<>());
        }
        //add dependency in adjaceny map
        map.get(out).add(in);
      }

      //bfs 
      Queue<Integer> q = new LinkedList<>();
      for(int i = 0; i< indegrees.length;i++) {
        if(indegrees[i] == 0) {
          //take independent node and add it in queue
          q.add(i);
        }
      }
      
      // if there is no independent node then can't finish the course
        if(q.size() == 0) return false;
        int count = 0;
      
        while(!q.isEmpty()) {
          //get the first independent node from the queue
          int curr = q.poll();
          count++;
          //check is there any dependency on the current course
          List<Integer> children = map.get(curr);
          if(children != null) {
            for(int child : children) {
              //reduce the indegree
              indegrees[child]--;
              if(indegrees[child] == 0) {
                //when indegree becomes 0 then the node becomes independent 
                //adding that node in q
                q.add(child);
              }
            }
          }
        }
      
        if(count == numCourses) return true;
        return false;
    }
}