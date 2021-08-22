/* Time Complexity :  O(V+E)
   Space Complexity :  O(V+E) where V is no of courses and E is edges between them
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0) return true;
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
            if(!hm.containsKey(prerequisites[i][1])){
                hm.put(prerequisites[i][1],new ArrayList<>());
            }
            hm.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        if(q.size()==0)
            return false;
        int size=0;
        while(!q.isEmpty()){
            int cur = q.poll();
            size++;
            List<Integer> li = hm.get(cur);
            if(li!=null){
                for(int n:li){
                     indegree[n]--;
                    if(indegree[n]==0)
                        q.add(n);
                }
            }
        }
        return size==numCourses;
    }
}