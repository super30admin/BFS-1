class Solution {
    
    HashMap<Integer, List<Integer>> dep = new HashMap();
    HashSet<Integer> visited = new HashSet();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length == 0){
            return true;
        }

        int[] in_deg = new int[numCourses];
        
        for(int[] pre : prerequisites){

            int req = pre[1];
            int to_take = pre[0];

            if(!dep.containsKey(req)){
                dep.put(req, new ArrayList<>());
            }

            List<Integer> updated= dep.get(req);
            updated.add(to_take);

            dep.put(req, updated);

            in_deg[to_take] ++;

        }

        //queue

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < in_deg.length; i++){

            if(in_deg[i] == 0){
                q.add(i);
            }

        }

        //go over the queue till its empty. 

        while(!q.isEmpty()){

            int node = q.poll();

            visited.add(node);
            //get the neighbors

            List<Integer> neighs = dep.get(node);

            if(neighs != null){

                for(int i = 0; i < neighs.size(); i++){
                int neigh = neighs.get(i);

                if(!visited.contains(neigh)){

                    in_deg[neigh] --;
                    if(in_deg[neigh] == 0){
                        q.add(neigh);
                    }

                }

                else{
                    return false;
                }

            }

            }

            

        }

        if(visited.size() == numCourses){
            return true;
        }

        return false;
        
    }
    
   
}