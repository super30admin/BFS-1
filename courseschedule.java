# Time complexity:O(n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();



        for(int i = 0 ; i < numCourses; i++){
            graph.put(i, new LinkedList<>());
        }

        int[] indegree  = new int[numCourses];

        for(int[] tuple:prerequisites){
            int course = tuple[0];
            int prerequisite = tuple[1];
            graph.get(prerequisite).add(course);
            indegree[course]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i++){
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }

            int count = 0;
            while(!queue.isEmpty()){
                int currentCourse = queue.poll();
                List<Integer> correspondingCourses =graph.get(currentCourse);
                for(int course: correspondingCourses){
                    indegree[course]--;

                if(indegree[course] == 0){
                    queue.add(course);
                }

                }

                count++;

            }
        if(count == numCourses) return true;
        return false;
    }
}