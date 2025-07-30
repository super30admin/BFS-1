/*
Time: O(V+E)
Space: O(V+E) + O(V)
*/

class Solution {

    HashMap<Integer, List<Integer>> map;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        map=new HashMap<>();
        int indegrees[]= new int[numCourses];

        for(int[] pr: prerequisites){

            indegrees[pr[0]]++;

            map.putIfAbsent(pr[1], new ArrayList<>());

            map.get(pr[1]).add(pr[0]);
        }

        Queue<Integer> q= new LinkedList<>();
        int completed=0;

        for(int i=0;i<numCourses;i++){

            if(indegrees[i]==0){ //add all independnet courses to the queue

                 q.add(i);
                 completed++;

            }
        }

        if(completed==numCourses) return true; // all are independent courses

        while(!q.isEmpty()){

            int curr=q.poll();

            List<Integer> dependencies=map.get(curr);

            if(dependencies!=null){

                for(int dependent: dependencies){

                    indegrees[dependent]--;

                    if(indegrees[dependent]==0){
                        q.add(dependent);
                        completed++;
                    }
                }
            }
        }

        return completed==numCourses;


    }
}