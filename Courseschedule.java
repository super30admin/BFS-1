//Time complexity: O(E+V)
//Space complexity: O(E+V)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees=new int[numCourses];
        HashMap<Integer,List<Integer>> map=new HashMap();
        for(int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1],new ArrayList());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q=new LinkedList();
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            List<Integer> subs=map.get(curr);
            if(subs!=null){
                for(int i:subs){
                    indegrees[i]--;
                    if(indegrees[i]==0){
                        q.add(i);
                    }
                }
            }
        }
        for(int i:indegrees){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}