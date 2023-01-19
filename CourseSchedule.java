//https://leetcode.com/problems/course-schedule/
//TC: V+E 
//SC: E
V- vertices ,E - edges
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegree = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites){
            indegree[pre[0]]++;
            if(!map.containsKey(pre[1])){
                map.put(pre[1],new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
        }
        int count =0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        if(queue.isEmpty())return false;
        while(!queue.isEmpty()){
            int c = queue.poll();
            //System.out.println(map.get(c));
            List<Integer> list = map.get(c);
            if(list==null) continue;
            for(int i : list){
                indegree[i]--;
                if(indegree[i]==0) {
                    queue.add(i);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}
