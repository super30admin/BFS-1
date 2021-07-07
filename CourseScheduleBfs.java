// Time Complexity : O(V + E)
// Space Complexity : O(V + E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int prerequisite[]:prerequisites){
            int pre = prerequisite[1];
            int course = prerequisite[0];
            inDegree[course]++;
            if(map.get(pre) == null){
                map.put(pre, new ArrayList());
            }
            map.get(pre).add(course);
        }
        
        Queue<Integer> q = new LinkedList();
        int count = 0;
        
        //courses with no prerequisites
        for(int i = 0;i < numCourses;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int pre = q.poll();
            count++;
            if(map.get(pre) != null){
                for(int course:map.get(pre)){
                    inDegree[course]--;
                    if(inDegree[course] == 0){
                        q.add(course);
                    }
                }
            }
        }
        return count == numCourses;
    }
}