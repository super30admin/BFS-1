// Time complexity 0(V+E)
// space complexity 0(n)
// Code successfully executed in leetcode.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegrees  = new int [numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        // prerequisites array processsing
        for(int i=0; i <prerequisites.length;i++)
        {
            indegrees[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])){
            map.put((prerequisites[i][1]), new ArrayList<>());
           
        }
        map.get((prerequisites[i][1])).add((prerequisites[i][0])); 
        }
           
    // iterating through indegrees array and adding elemnt to queue
        for (int i=0; i<indegrees.length;i++){
        if(indegrees[i]==0) q.add(i);
      }
    while(!q.isEmpty()){
        int course = q.poll();
        //course to course need to check edges as well
        List<Integer> children = map.get(course);
        if(children !=null){
        for(int child : children) {
            indegrees[child]--;
            if(indegrees[child]==0) q.add(child);
        }
    }
    }
    for(int i=0; i<indegrees.length;i++){
        if(indegrees[i] > 0) return false;
    }
    return true;
}
}
