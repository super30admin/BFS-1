class Solution {
    //Time complexity: O(V+E)
    //Space complexity: O(V+E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)
            return true;
        Map<Integer,List<Integer>> hm=new HashMap<>();
        int[] inDegrees=new int[numCourses];
        for(int[] edge:prerequisites){
            inDegrees[edge[0]]++;
            if(!hm.containsKey(edge[1])){
                hm.put(edge[1],new ArrayList<>());
            }
            hm.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        int c=0;
        for(int i=0;i<numCourses;i++){
            if(inDegrees[i]==0){
                q.add(i);
                c++;
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            List<Integer> li=hm.get(curr);
            if(li!=null){
                for(int edge:li){
                    inDegrees[edge]--;
                    if(inDegrees[edge]==0){
                        q.add(edge);
                        c++;
                        if(c==numCourses)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}