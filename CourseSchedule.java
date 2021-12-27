class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null && prerequisites.length == 0) {
            return false;
        }

        int inDegree[] = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int completedCourses = 0;

        for(int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;

            if (!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }

            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                completedCourses++;
                queue.add(i);
            }
        }


        while(!queue.isEmpty()) {
            int currentCourse = queue.poll();

            if(map.get(currentCourse) != null) {
                for(int dependent : map.get(currentCourse)) {
                    inDegree[dependent]--;

                    if(inDegree[dependent] == 0) {
                        completedCourses++;
                        queue.add(dependent);
                    }
                }
            }
        }

        return completedCourses == numCourses;
    }
}