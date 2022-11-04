//TC: O(V+E) vertex, edge
//SC: O(V+E)
//works in leetcode

public class CourseFinish {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //coursenum with incoming edges
        int [] indegree = new int[numCourses];

        //stores course(key) and other courses(value) that depend on key
        Map<Integer, List<Integer>> preqMap = new HashMap<>();

        for (int[] pre:prerequisites){
            indegree[pre[0]] ++;
            if(!preqMap.containsKey(pre[1])){
                preqMap.put(pre[1], new ArrayList<>());
            }
            preqMap.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        //init queue
        for(int c=0; c<numCourses; c++){
            if(indegree[c]==0){
                q.add(c);
            }
        }

        int completedCourses=0;

        while(!q.isEmpty()){
            int course = q.remove();
            completedCourses++;
            //get courses from map whose indegree need to be reduced by 1
            List<Integer> dep = preqMap.get(course);

            if(dep!=null){
                for(int x: dep){
                    indegree[x]--;

                    if(indegree[x]==0)
                        q.add(x);
                }
            }

        }

        return completedCourses==numCourses;


    }

    public static void main(String [] args){
        int [][] prerequisites ={{1,0},{2,1},{3,1},{4,2},{4,3},{5,4}};
        System.out.println(canFinish(6, prerequisites));

    }
}
