
class TopologicalSort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inIndegree = new int[numCourses];
        HashMap<Integer, List<Integer>>  aD = new HashMap<>();
        for(int[] pr : prerequisites)
        {
            inIndegree[pr[0]]++;
            aD.putIfAbsent(pr[1], new ArrayList<>());
            aD.get(pr[1]).add(pr[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < inIndegree.length; i++){
            if(inIndegree[i] == 0)
            {
                queue.add(i);
                count++;
            }
        }
        if(queue.isEmpty()) return false;
        if(count == numCourses) return true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            List<Integer> edges = aD.get(x);
            if(edges != null){
                for(int i: edges)
                {
                    inIndegree[i]--;
                    if(inIndegree[i] == 0) {
                        queue.add(i);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
        return false;
    }
}