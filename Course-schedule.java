class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegarr = new int[numCourses];
        for(int[] prerequisite: prerequisites){
            int indep = prerequisite[1];
            int dep = prerequisite[0];
            indegarr[dep]++; //in degree array will keep all inwards arrow count
            //creating the hashmap
            if(!map.containsKey(indep)){
                //create new list
                map.put(indep, new ArrayList<>());

            }
            map.get(indep).add(dep);
        }

        Queue<Integer> q = new LinkedList<>();

        int count = 0;
        for(int i = 0 ;i<numCourses; i++){
            //if no dep add it to q
            if(indegarr[i]== 0){
                q.add(i);
                count++;
            }
        }

        if(count==numCourses) return true;
        while(!q.isEmpty()){
            int curr = q.poll();
            //look for dependents in map
            List<Integer> children = map.get(curr);
            //reduce their indegrees by 1
            if(children!=null){
                for( int child: children){
                    indegarr[child]--;
                    if(indegarr[child]==0){
                        q.add(child);
                        count++;
                    }
                    if(count==numCourses) return true;
                }
            }


        }
        return false;
    }
}