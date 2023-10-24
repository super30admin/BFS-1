//Time Complexity : O(n)
//Space Complexity : O(n)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for (int[] pr: prerequisites){
            int out = pr[1];
            int in = pr[0];
            indegrees[in]++;
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        int count =0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses;i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        if(count == numCourses){return true;}
        if(q.isEmpty()){return false;}
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child: children){
                indegrees[child]--;
                if(indegrees[child] == 0){
                    q.add(child);
                    count++;
                    }
                }
            }
            
        }
    return count == numCourses;
}
}
