//Time Complexity: O(V+E) V is numCourse, E is the edges 
//Space Complexity: O(V+E) 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[]inDegrees = new int [numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            inDegrees[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegrees.length; i++){
            if(inDegrees[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child : children){
                    inDegrees[child]--;
                    if(inDegrees[child] == 0){
                        q.add(child);
                    }
                }
            }
        }
        for(int i = 0; i < inDegrees.length; i++){
            if(inDegrees[i] > 0){
               return false;
            }
        }
        return true;
    }
}