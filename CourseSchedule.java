//TC: O(V+e)
//SC: O(v+e)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0){
            return true;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] intdegrees = new int[numCourses];
        for(int[] pr : prerequisites){
                intdegrees[pr[0]]++;
                if(!(map.containsKey(pr[1]))){
                    map.put(pr[1], new ArrayList<>());
                }
                map.get(pr[1]).add(pr[0]);
        }
        int count =0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< intdegrees.length; i++){
            if(intdegrees[i] == 0) {
                q.add(i);
                count++;
            }

        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(Integer child : children) {
                    intdegrees[child]--;
                    if(intdegrees[child] == 0){
                        q.add(child);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
        return false;
    }
}