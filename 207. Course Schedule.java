class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    Map<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        for(int[] prere : prerequisites){
            int pre = prere[1];
            int cur = prere[0];
            if(map.containsKey(pre)){
                map.get(pre).add(cur);
            }else{
                List<Integer> curList = new ArrayList<>();
                curList.add(cur);
                map.put(pre, curList);
            }
        }
        int[] status = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(isCircle(i, status, map)){
                return false;
            }
        }
        return true;
    }
    public boolean isCircle(int i, int[] status, Map<Integer, List<Integer>> map){
        //marking with 1 indicates the course is visiting
        if(status[i] == 1){
            return true;
        }
        // marketing with 2 indicates the course is completed
        if(status[i] == 2){
            return false;
        }
        // when there is only one course, then this course will not enter the map
        if(!map.containsKey(i)){
            return false;
        }
        status[i] = 1;
        
        for(int j:map.get(i)){
            if(isCircle(j, status, map)){
                return true;   
            }
        }
        status[i] = 2;
        return false;
    }
}