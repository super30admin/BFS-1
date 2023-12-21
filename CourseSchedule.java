// indeg - O(E) adj list O(V) queue O(V+E) Check result O(E)
// T.C O(V+E) //Vertices + Edges of graphical rep
//S.C O(V+E)
import java.util.*;
import java.util.LinkedList;


//Create indegrees array to maintain count of courses each course is dependent on
//Create adjacency list to maintain list with key as indep course and value as others dependent on the key
//add indep courses to queue and process each of the course dependent on it in BFS to check if they can be scheduled.
//for each queue processing dec the num in indeg array. If the courses can be scheduled, there must not be any remaining course in indeg array
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create indegrees array and adjacency list
        int[] indeg = new int[numCourses];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] pre : prerequisites){
            indeg[pre[0]]++;
            if(!map.containsKey(pre[1])){
                map.put(pre[1],new ArrayList<Integer>());
            }
            map.get(pre[1]).add(pre[0]);
        }

        //BFS approach - needs queue to process
        Queue<Integer> q = new LinkedList();
        int count=0;
        for(int i=0;i<indeg.length;i++){
            if(indeg[i] ==0 ){
                q.add(i);
                count++;
            }
        }
        //If all courses are independent
        if(count == numCourses) return true;
        while(!q.isEmpty()){
            Integer c = q.poll();
            List<Integer> li = map.get(c);
            if(li!=null){
                for(Integer l : li){
                    indeg[l]--;
                    if(indeg[l]==0)
                        q.add(l);
                }
            }
        }
        for(int i=0;i<indeg.length;i++){
            if(indeg[i] !=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        boolean res = cs.canFinish(2,new int[][]{{0,1}});
        System.out.println(res);
    }
}