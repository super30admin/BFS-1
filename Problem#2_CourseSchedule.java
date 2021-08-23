class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Base case
        if(prerequisites.length==0){
            return true;
        }
        //All dependency courses initialised to 0 initially:
        int[] dependents = new int[numCourses];
        //Using adjacency matrix
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : prerequisites){
            dependents[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        //Traverse BFS - to isolate all independent course
        // then free up dependent courses
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(dependents[i]==0){
                q.add(i);
                System.out.print("Adding to map: "+i);
            }
        }
        //No independent courses, meaning deadlock coz of dependency.
        if(q.size()==0){
            return false;
        }
        int cnt=0;
        while(!q.isEmpty()){
            //Start freeing up the courses in queue if array is 0
            int curr = q.poll();
            cnt++;
            List<Integer> freeUpCourses = map.get(curr);
            if(freeUpCourses!=null){
                for(int course : freeUpCourses){
                    dependents[course]--;
                    if(dependents[course]==0){
                        q.add(course);
                    }
                }
            }     
        }
            return cnt==numCourses;
        }
    }
