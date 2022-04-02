#time complexity : O(v+e)
#space complexity : O(n)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> adList = new HashMap<>();
        for(int[] p : prerequisites){
            inDegree[p[0]]++;
            if(!adList.containsKey(p[1])){
                adList.put(p[1],new ArrayList<>());
            }
            adList.get(p[1]).add(p[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<numCourses;i++){
            //System.out.println(i);
            if(inDegree[i]==0){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()){
            return false;
        }
        
        while(!q.isEmpty()){
            int ele = q.poll();
            //System.out.println(ele);
            List<Integer> li = adList.get(ele);
            if(li == null) continue;
            for(int i : li){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    q.add(i);
                    count++;
                }
            }
        }
        if(count >= numCourses){
            return true;
        }
        
        
        return false;
    }
}
