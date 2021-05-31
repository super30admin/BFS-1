// Time: v+e where v= number of course and e=number of elements in prerequisites array
//space: v+e
//Did it run successfully on leetcode: yes
//Did you face any problem: No
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //map to store adjacency list
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        //store in-degree count of nodes
        int[] inDegree = new int[numCourses];

        //create adjacency list
        for(int[] preReq: prerequisites){
            int in = preReq[0];
            int out = preReq[1];
            //if vertex doesn't exist
            if(!graph.containsKey(out)){
                //add a new ArrayList as the value for current vertex
                graph.put(out, new ArrayList<>());
            }
            //insert curr in elements as adjacent to curr out element
            graph.get(out).add(in);
            //increae indegree of curr out element
            inDegree[in]++;
        }

        //Queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        //for all nodes
        for(int i=0; i<inDegree.length;i++){
            //if indegree is 0 i.e. no dependency on other
            if(inDegree[i]==0){
                //add to que
                q.add(i);
            }
        }
        //if que is empty i.e. no independent node to start
        if(q.isEmpty()) return false;

        //q is not empty
        while(!q.isEmpty()){
            //get left most node from queue
            int curr = q.poll();
            //if curr node has no adjacent nodes or child
            if(graph.get(curr) == null) continue;
            //loop through all the children of curr nodes
            for(int child: graph.get(curr)){
                //decreement indegree of current child
                inDegree[child]--;
                //if indegree of curr child is zero i.e. curr child is independent
                if(inDegree[child]==0){
                    //add curr child to queue
                    q.add(child);
                }
            }
        }
        //for all nodes
        for(int curr: inDegree){
            //if any node has indegree more than zero i.e. any dependent node present
            if(curr!=0) return false;
        }

        return true;
    }
}