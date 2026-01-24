class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        int [] indegrees = new int [numCourses];
        for(int [] edge: prerequisites){
            int de = edge[0];
            int inde = edge[1];
            if(!map.containsKey(inde)){
                map.put(inde, new ArrayList<>());
            }
            map.get(inde).add(de);
            indegrees[de]++;
        }
        Queue <Integer> q= new LinkedList<>();
        int count=0;
        for(int i=0; i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
                count++;
            }
        }
        if(count==numCourses) return true;
        if(q.isEmpty()){
            return false;
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children= map.get(curr);
            if(children != null){
                for(int child: children){
                indegrees[child]--;
                if(indegrees[child]==0){
                    q.add(child);
                    count++;
                    if(count==numCourses) return true;
                }
            }
            }
            
        }
        return false;
    }
}