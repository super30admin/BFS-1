//Time Complexity : O(V+E). V is the number of numCourses and E is the number of edges or prerequisites
//Space Complexity : O(V+E). Indegree array uses O(V), Hashmap uses O(V+E), Queue uses O(V) and List uses O(V). Hence total is O(V+E).

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return false;
        }
        //create a indegree array/dependency array to keep track of number of prerequisites for each course
        int[] indegree = new int[numCourses];
        //use a hash map to keep track of the neighbouring nodes/prereqs for each course
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        //populate the indegree array and hashmap
        for(int[] edges : prerequisites){
            indegree[edges[0]]++;//0 has the value course and 1 has the prereq for that course
            if(!map.containsKey(edges[1])){
                map.put(edges[1],new ArrayList<>());
            }
            map.get(edges[1]).add(edges[0]);
        }
        //use a queue to keep track of the courses with no prerequisites
        Queue<Integer> q = new LinkedList<>();
        //add the courses with zero prerequisites into queue from indegree array
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;//variable to keep track if all the prereq courses could be taken
        //each time a course with zero prerequisites is completed mark them i.e decreement its prerequisites in indegree array and simultaneously update the queue
        while(!q.isEmpty()){
            int course = q.poll();
            count++;//increement every time a prereq is completed or indegree of a course is zero
            List<Integer> edges = map.get(course);
            if(edges!=null){
                for(int item : edges){
                    indegree[item]--;
                    if(indegree[item]==0){
                        q.add(item);
                    }
                }
            }
        }
        /*for(int j=0;j<indegree.length;j++){
            if(indegree[j]>0){
                return false;
            }
        }
        return true;*/
        return count == numCourses;
    }
}