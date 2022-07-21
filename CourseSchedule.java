//Time Complexity:O(V+E)
//Space Complexity :O(V+E)//Height of the tree using recursive stack
//Amazon Interview
//Topological approach:First take the courses as indexes and their indegree as the course must be taken as preriquistes.Using hashmap {[0:2,3][2:1,4][3:1,5][4:5],[5:[]],[1:[]]},it starts with independent node,the empty list 1 and 5 are not dependent on anything.starts from vertices and edges as example in and out to graph.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        
        //Indegrees array
        int[] indegrees = new int[numCourses];
        //Adajacency list
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int[] req: prerequisites){
            int in = req[0];//req[1]
            int out = req[1];//req[0]
            indegrees[in]++;
            if(!map.containsKey(out)){
                map.put(out,new ArrayList<>());
            }
            map.get(out).add(in);
        }
        //BFS
        int completedCourses = 0;//can comment if bottom for loop using
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(indegrees[i] == 0){
                q.add(i);
                completedCourses++;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if(edges == null)continue;
            for(int edge : edges){
                indegrees[edge]--;
                if(indegrees[edge] == 0){
                    q.add(edge);
                    completedCourses++;
                }
            }
        }
        // for(int i = 0;i<numCourses;i++){
        //     if(indegrees[i]!=0){
        //         return false;
        //     }
        // }
        //return true;
        return completedCourses == numCourses;
    }
}