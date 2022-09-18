// Time Complexity : O(v+e)
// Space Complexity : o(v+e)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Problem2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //bfs approach

        //hashmap of independent nodes to list of dependent nodes
        HashMap<Integer, List<Integer>> m = new HashMap<>();

        //indegrees array
        int[] in = new int[numCourses];

        //for every edge we will iterate to get the indegree
        for(int[] edge: prerequisites){

            in[edge[0]]++;

            if(!m.containsKey(edge[1])){

                m.put(edge[1], new ArrayList<>());
            }
            m.get(edge[1]).add(edge[0]);
        }

        //bfs
        Queue<Integer> q = new LinkedList<>();
        int count =0;

        for(int i=0; i<numCourses; i++){

            if(in[i]==0){
                q.add(i);
                count++;
            }

            if(count == numCourses) return true;

            while(!q.isEmpty()){

                int curr = q.poll();
                List<Integer> child = m.get(curr);

                if(child!=null){

                    for(int c: child){
                        in[c]--;
                        if(in[c]==0){
                            q.add(c);
                            count++;
                            if(count==numCourses) return true;
                        }
                    }
                }
            }

        }
        return false;
    }
}