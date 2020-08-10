class CourseSchedule{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0){
            return true;
        }
        int[] inedge = new int[numCourses];
        Map<Integer,List<Integer>> edges = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            inedge[prerequisites[i][0]]++;
            if(!edges.containsKey(prerequisites[i][1])){
                edges.put(prerequisites[i][1],new ArrayList<Integer>());
            }
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);


        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<inedge.length;i++){
            if(inedge[i]==0){
                q.add(i);
            }
        }
        int count =q.size();
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> temp = edges.get(curr);
            if(temp!=null){
                for(int i : temp){
                    inedge[i]--;
                    if(inedge[i]==0){
                        q.add(i);
                        count++;
                    }
                }
            }
        }

        if(count==inedge.length) return true;

        return false;
    }
    //Time COmplexity : o(c) c->number of courses
    //Space complexity :o(V+E) courses + dependencies
    //start from independent couses and start decreasing its dependends inverted edge by one and if the inverted edges is zero add to queue and repeat BFS and also increase the course complete count. @ last if count == number of courses return true else false.
}