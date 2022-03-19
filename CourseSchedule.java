/*
//time complexity: O(V+E)
//space complexity: O(V)

approach : so basically we make an indegree array to check dependencies and then
generate adjacency matrix so that we can figure out what are the dependents for that
course so that when we process them the other dependents can be [rocessed]. But
we process any course only if it's indegree is 0 else we don't add it in the Queue
for our BFS solution. So until our queue is empty we will keep adding and processing
the elements. Once our queue becomes empty, we will check if none of our courses
have indegree non zero which indicates all courses were completed. else we could
not finish all the courses. 
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //in degree map

        //adjacency matrix

        int[] indegrees = new int[numCourses];

        Map<Integer, List<Integer>> dependencies = new HashMap<>();

        Queue<Integer> bfs = new LinkedList<>();


        for(int i = 0; i < prerequisites.length; i++)
        {
            indegrees[prerequisites[i][0]]++;

            if(!dependencies.containsKey(prerequisites[i][1])){
                dependencies.put(prerequisites[i][1], new ArrayList<>());
            }

            dependencies.get(prerequisites[i][1]).add(prerequisites[i][0]);

        }


        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                bfs.add(i);
            }
        }

        while(!bfs.isEmpty()){

            int size = bfs.size();

            while(size > 0){

                int course = bfs.poll();

                if(dependencies.get(course) == null){
                    size--;
                    continue;
                }

                for(int dep : dependencies.get(course)){
                    indegrees[dep]--;
                    if(indegrees[dep] == 0){
                        bfs.add(dep);
                    }
                }

                size--;
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] != 0){
                return false;
            }
        }

        return true;
    }
}
