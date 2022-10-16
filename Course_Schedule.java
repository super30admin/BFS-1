// TC : O(m*n)
// SC : O(m * n)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] a = new int[numCourses];
        
        for(int [] k : prerequisites) {
            if(!map.containsKey(k[1])) {
                map.put(k[1], new ArrayList());
            }
            map.get(k[1]).add(k[0]);
            a[k[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < a.length; i++) {
            if(a[i] == 0)
                q.add(i);
        }
        
        
        
        while(!q.isEmpty()) {
            Integer ele = q.poll();
            System.out.println(ele);
            if(!map.containsKey(ele))
                continue;
            List<Integer> li = map.get(ele);
            for(Integer l : li) {
                a[l]--;
                if(a[l] == 0)
                    q.add(l);
            }
        }
        
        //System.out.println(a[0] + "" + a[1]);
        
        for(int i : a) {
            if(i != 0)
                return false;
        }
        return true;
    }
}
