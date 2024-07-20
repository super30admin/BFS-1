//Tc: O(v+e)
//Sc: O(v+e)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            int in = prerequisite[0];
            int out = prerequisite[1];
            indegrees[in]++;
            if(!map.containsKey(out)) {
                map.put(out,  new ArrayList<>());
            } 
            map.get(out).add(in); 
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0 ; i<numCourses ; i++) {
            if(indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }
        if(count == numCourses) return true;
        if(count == 0) return false;
        while(!q.isEmpty()) {
            int popped = q.remove();
            List<Integer> temp = map.get(popped);
            if(temp!=null) {
                for(int t : temp) {
                    indegrees[t]--;
                    if(indegrees[t] == 0) {
                        q.add(t);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
        if(count == numCourses) return true;
        return false;
    }
}