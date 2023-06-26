import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)
            return true;
        HashMap<Integer, List<Integer>> courseMapping=new HashMap<>(); //hashmap to add the course mapping
        int[] inDegree=new int[numCourses]; //to maintain the current dependency of courses

        for(int[] pr:prerequisites){
            //pr[0] is dependent course
            //pr[1] is independent course
            inDegree[pr[0]]++;
            if(!courseMapping.containsKey(pr[1])){
                courseMapping.put(pr[1], new ArrayList<>());
            }
            courseMapping.get(pr[1]).add(pr[0]);
        }
        Queue<Integer> independentQue=new LinkedList<>();
        int count=0;
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                independentQue.add(i);
                count++;
            }
        }
        while(!independentQue.isEmpty()){
            int curr=independentQue.poll();
            List<Integer> children=courseMapping.get(curr);
            if(children!=null){
                for(int child:children){
                    inDegree[child]--;
                    if(inDegree[child]==0){
                        independentQue.add(child);
                        count++;
                        if(count==numCourses){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
