class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0){
            return true;
        }

        int []indegree = new int[numCourses];
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int []prerequisite : prerequisites){
            int to = prerequisite[0];
            int from = prerequisite[1];
            indegree[to]++;
            if(!map.containsKey(from)){
                map.put(from,new ArrayList<>());
            }
            map.get(from).add(to);
        }

        Queue<Integer>q = new LinkedList<>();
        int count = 0;
        for(int i = 0 ; i<numCourses;i++){
            if(indegree[i]==0){
                q.add(indegree[i]);
                count++;
            }
        }

        while(!(q.isEmpty()))
        {
            int curr = q.poll();
            List<Integer>edges = map.get(curr);
            if(edges==null){
                continue;
            }

            for(int e : edges){
                indegree[e]--;
                if(indegree[e]==0){
                    q.add(e);
                    count++;
                }
            }
        }return count==numCourses;
    }
}
