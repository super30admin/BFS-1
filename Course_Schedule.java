/**
 * Time: O(n) n-prerequisites array length
 * Space: O(n)
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] count = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        HashMap<Integer,List> hmap = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            count[prerequisites[i][1]]++;
            if(hmap.getOrDefault(prerequisites[i][0],null) == null)
                hmap.put(prerequisites[i][0],new ArrayList<Integer>());
            hmap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        //System.out.println(hmap.size());
        for(int i=0; i<numCourses;i++){
            if(count[i]==0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            int ele = queue.poll();
            List<Integer> lst = hmap.getOrDefault(ele,null);
            if(lst == null || lst.size() == 0) continue;
            for(int i=0;i<lst.size();i++){
                count[lst.get(i)]--;
                if(count[lst.get(i)] == 0)queue.offer(lst.get(i));
            }
        }

        for(int i=0; i<numCourses;i++){
            if(count[i]!=0)
                return false;
        }
        return true;
    }
}