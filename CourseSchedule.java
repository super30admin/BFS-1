class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Time Complexity: O(N)
        //Space Complexity: O(N)
       HashMap <Integer, List<Integer>> map = new HashMap<>();
       int[] numPre = new int[numCourses];
       Queue<Integer> q = new LinkedList<>();

        int preLen = prerequisites.length;
       for (int i = 0; i< preLen; i++){
        numPre[prerequisites[i][0]]++;
        if (map.containsKey(prerequisites[i][1])){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        } else {
            map.put (prerequisites[i][1], new ArrayList<Integer>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);

        }
       } 
       for ( int i =0; i< numCourses;i++){
        if (numPre[i] ==0)
        q.offer (i);
       }
       if (q.size() == 0 ){
        return false;
       }
       
       while (!q.isEmpty()){
            int len = q.size();
            for (int i =0;i <len;i ++){
                int num = q.poll();
                List<Integer> list = map.getOrDefault(num, new ArrayList<>());
                for (int n : list){
                    numPre[n]--;
                    if (numPre[n] == 0)
                    q.offer(n);
                }
            }
       }
        for ( int i =0; i< numCourses;i++){
        if (numPre[i] !=0)
       return false;
       }
       return true;

    }
}