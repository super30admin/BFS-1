// TC: O(
class Solution {
    public boolean canFinish(int num, int[][] prereq) {
        if(prereq == null || prereq.length == 0) {
            return true;
        }

        int[] indegree = new int[num];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p : prereq) {
            int prev = p[1];
            int curr = p[0];
            List<Integer> dep = map.getOrDefault(prev, new ArrayList<>());
            dep.add(curr);
            map.put(prev, dep);
            indegree[curr]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < num; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            count++;
            List<Integer> dep = map.get(curr);
            if(dep != null) {
                for(int n : dep) {
                    indegree[n]--;
                    if(indegree[n] == 0) {
                        q.add(n);
                    }
                }
            }
        }
        if(count == num) {
            return true;
        }
        return false;
    }
}