/**
 *  Time complexity - O(V+E)
 *  Space complexity - O(V+E)
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> map = new HashMap();

        if(prerequisites.length == 0){
            return true;
        }

        int[] inDegree = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            if(!map.containsKey(prerequisite[1])){
                map.put(prerequisite[1],new ArrayList<>());
            }
            inDegree[prerequisite[0]]++;
            map.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i < inDegree.length; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        int coursesDone = 0;
        while(!queue.isEmpty()){
            coursesDone++;
            int courseId = queue.poll();
            if(map.containsKey(courseId)){

                for(int course : map.get(courseId)){
                    inDegree[course]--;
                    if(inDegree[course]==0){
                        queue.add(course);
                    }
                }
            }
        }

        return coursesDone == numCourses ;
    }
}