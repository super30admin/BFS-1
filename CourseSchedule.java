import  java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
        Approach : Using BFS
        TC: O(V+E)
        SC: O(V+E)

        */
        if(numCourses==0) return true;

        int indegree[]=new int[numCourses];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        int coursesTaken=0;

        for(int pre[]:prerequisites){
            indegree[pre[0]]++;
            if(!map.containsKey(pre[1])){
                map.put(pre[1],new ArrayList<>());
            }

            map.get(pre[1]).add(pre[0]);
        }

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.poll();
                coursesTaken++;
                List<Integer> li=map.get(curr);
                if(li!=null && li.size()>0){
                    for(int course:li){
                        indegree[course]--;
                        if(indegree[course]==0){
                            q.add(course);
                        }
                    }
                }
            }
        }

        return coursesTaken==numCourses;
    }
}
