class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length < 2) return true;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        int[] prereqCount = new int[numCourses];
        for(int[] i : prerequisites ){
           
            map.putIfAbsent(i[1], new ArrayList<Integer>());
           
            map.get(i[1]).add(i[0]);
           
            prereqCount[i[0]]++;
           
        }
        for(int i =0 ; i < numCourses; i++){
            if(prereqCount[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            if(map.get(curr)!=null){
                for(int i : map.get(curr)){
                prereqCount[i]--;
                if(prereqCount[i] ==0){
                    q.add(i);
                }
            }
            }
            
        }
        
        for(int i =0 ;i < numCourses; i++){
            if(prereqCount[i] !=0) return false;
        }
        return true;
    }
}