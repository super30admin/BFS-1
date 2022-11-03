class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] id = new int[numCourses];
        Map<Integer, List<Integer>> p = new HashMap<>();
        for(int[] pre : prerequisites){
            id[pre[0]]++;
            if(!p.containsKey(pre[1])){
                p.put(pre[1], new ArrayList<>());
            }
            p.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int c = 0; c<numCourses; c++){
            if (id[c]==0){
                q.add(c);
            }
        }
        int cc =0;
        while(!q.isEmpty()){
            int course = q.remove();
            ++cc;
            List<Integer> d = p.get(course);
            if(d != null){
                for(int x:d){
                    id[x]--;
                        if(id[x]==0){
                            q.add(x);
                        }
                }
            }
        }
        return cc == numCourses;
    }
}
//tc=O(n)
//sc=O(n)
