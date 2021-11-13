//Time Complexity: O(V+E)
//Space Complexity: O(V+E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] count = new int[numCourses];
        HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        List<Integer> temp;
        for(int prereq[]:prerequisites){
            count[prereq[0]]++;
            temp = adjacencyMap.getOrDefault(prereq[1], new ArrayList<>());
            temp.add(prereq[0]);
            adjacencyMap.put(prereq[1], temp);
        }

        Queue<Integer> bfs = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(count[i]==0)
                bfs.add(i);
        }


        while(!bfs.isEmpty()){

            temp = adjacencyMap.getOrDefault(bfs.remove(), new ArrayList<>());
            for(int i:temp){
                count[i]--;
                if(count[i]==0)
                    bfs.add(i);
            }
        }

        for(int i:count)
            if(i!=0)
                return false;

        return true;

    }
}