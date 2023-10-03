/*

Course Schedule (https://leetcode.com/problems/course-schedule/)

TC : O(v+e)
SC : O(v+e)
Leet Code : Yes

 */

 class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        
        if(numCourses == 0){
            return true;
        }

        int[] indeg = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        
        int count = 0;
        for(int[] prereqs : prereq){
            int to = prereqs[0];
            int from = prereqs[1];
            indeg[to]++;
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }

        for(int i = 0; i<indeg.length ;i++){
            if(indeg[i] == 0){
                q.add(i);
                count++;
            }
        }

        if(q.isEmpty()){
            return false;
        }

        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> edges = map.get(course);
            if(edges == null){
                continue;
            }

            for(int edge : edges){
                indeg[edge]--;
                if(indeg[edge] == 0){
                    q.add(edge);
                    count++;
                }
            }
        }

        return count == numCourses;
    }
}