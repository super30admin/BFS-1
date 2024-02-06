class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] arr = new int[numCourses];

        for(int i = 0; i < numCourses; i++) map.put(i, new HashSet<>());

        for(int[] preReq : prerequisites){
            arr[preReq[0]]++;
            map.get(preReq[1]).add(preReq[0]);
        }

        while(!map.isEmpty()){
            int idx = -1;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == 0){
                    idx = i;
                    arr[i] = Integer.MAX_VALUE;
                    break;
                }
            }

            if(idx == -1) return false;

            Set<Integer> set = map.get(idx);
            for(int foo: set){
                arr[foo]--;
            }

            map.remove(idx);
        }

        return true;
        
    }
}
