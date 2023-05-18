// Time: (V+E) 
// Space: (V+E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i = 0 ; i<numCourses; i++){
            map.put(i,new ArrayList<>());
        }

        for(int i = 0 ; i<prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            
        }
        // System.out.println(map);
        // System.out.println(Arrays.toString(indegree));

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int totalCourses = numCourses;
        while(!q.isEmpty()){
            int size = q.size();
            int cur = q.poll();
            totalCourses--;
            List<Integer> courses = map.get(cur);
            System.out.println(cur);

            for(int i = 0 ; i< courses.size() ; i++){
                indegree[courses.get(i)]--;
                if(indegree[courses.get(i)]==0){
                    q.add(courses.get(i));
                }
            }
        }
        // System.out.println(Arrays.toString(indegree));
        // System.out.println(totalCourses);
        return totalCourses == 0 ? true : false;
        
    }
}