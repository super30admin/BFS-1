//TC = O(V+E)
// SC = O(V+E)

class CourseSchedule{
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if(prerequisites == null || prerequisites.length == 0) return false;
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] indegree = new int[numCourses];
            //Making indegress array
            for(int pr: prerequisites){
                indegree[pr[0]]++; //pr[0] -> Dependent pr[1] -> independent
                if(!map.containsKey(pr[1])){
                    map.put(pr[1], new ArrayList<>();)
                }
                map.get(pr[1]).add(pr[0]);
            }


            //now making queue and addling independet now
            int count = 0;
            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<indegree.length;i++){
                if(indegree[i]==0){
                    q.add(i);
                }
            }

            while(!q.isEmpty()){
                int curr = q.poll();
                List<Integer> child = map.get(curr);
                if(child != null){
                    for(Integer ch : child){
                        indegree[ch]--;
                        if(indegree[ch] == 0){
                            q.add(ch);
                            count++;
                            if(count == numCourses) return true;
                        }
                    }
                }
            }
        return false;
    }
}

