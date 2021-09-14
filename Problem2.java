// Time Complexity :O(V+E) 
// Space Complexity :O(V+E)
// Did this code successfully run on Leetcode :yes

// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //indegree array
        int[] indegrees = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        //traverse throught each list in prerequisites and add it in indegrees
        for(int[] edge : prerequisites){
            indegrees[edge[0]]++;
            //also put that list in hashmap
             if(!map.containsKey(edge[1])){
                 map.put(edge[1],new ArrayList<>());
             }
            map.get(edge[1]).add(edge[0]);
        }
        //to count no of courses going into queue
        int count =0;
        //iterate over indegrees array and find 0 cause its independent and add it to queue
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.add(i);
                count++;
            }
        }
        //next step is to remove the course and reduce its dependencies
        while(!q.isEmpty()){
            int curr =q.poll();
            //get the list of dependencies of curr
            List<Integer> children= map.get(curr);
            if(children !=null){
                for(int child : children){
                    //reduce those dependencies by 1 in indegrees array
                    indegrees[child]--;
                    //if 0 then we need to add it to queue to process
                    if(indegrees[child]==0){
                      q.add(child);
                      count++;   
                }
            }
        }
    }
  return count==numCourses;
    }
}