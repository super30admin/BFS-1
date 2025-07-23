class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg=new int[numCourses];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int[] p:prerequisites){
            indeg[p[0]]++;
            map.putIfAbsent(p[1], new ArrayList<>());
            map.get(p[1]).add(p[0]);
        }
       Queue<Integer>q=new LinkedList<>();
       int count=0;
       for(int i=0;i<numCourses;i++)
{
if(indeg[i]==0){
    q.add(i);
    count++;
}
}
while(!q.isEmpty()){
    int curr=q.poll();
    List<Integer>dependence=map.get(curr);
    if(dependence!=null){
        for(int d:dependence){
            indeg[d]--;
            if(indeg[d]==0){
                q.add(d);
                count++;
                if(count==numCourses)return true;
            }

        }
    }

}
return count==numCourses;
        
    }
}