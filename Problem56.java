Executed in leet code-Yes
Time complexity- v+e
Space complexity - ve
class Solution {
    public boolean canFinish(int numCourses, int[][] prereqs) {
        HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        int[] indegrees = new int[numCourses];
        for(int[] intArr: prereqs){
            indegrees[intArr[0]]=indegrees[intArr[0]]+1;
            map.put(intArr[1],new ArrayList<Integer>());
        }
          for(int[] intArr: prereqs){
              map.get(intArr[1]).add(intArr[0]);
                map.put(intArr[1],map.get(intArr[1]));
        }
        Queue<Integer> q= new LinkedList<Integer>();
        for(int i=0;i< indegrees.length;i++){
            if(indegrees[i]==0) q.add(i);
        }
        while (!q.isEmpty()){
            Integer cur= q.poll();
            if(map.get(cur)!=null){
                for(Integer later: map.get(cur)){
                  indegrees[later]--;
                  if(indegrees[later]==0) q.add(later);
                }       
            }

        }
        for(int i=0;i< indegrees.length;i++){
            if(indegrees[i]>0) return false;
        }
        return true;
        
    }
}
