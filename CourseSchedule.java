//time complexity:O(V+E)=O(number of courses + prerequisite array length)
//space complexity:O(V+E)=O(number of courses + prerequisite array length)
/*Approach
-Making a map to store adjacency list, also making an array to store indegrees of each node
-if for a node(i.e course) indegree is 0 that means it is free from other courses and can be taken
-to store that we made a queue,every time we take a course we decrease its adjacents indegree by 1
and if it becomes 0 that means it can be taken,so that is again added to th queue
-atlast we will check our indegree array if every nodes indegree is 0 that means it has been taken
so we will return true and if this fails we will return true
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] edge: prerequisites){
            if(map.containsKey(edge[1])){
                map.get(edge[1]).add(edge[0]);
            }
            else{
                List<Integer> curr = new ArrayList<>();
                curr.add(edge[0]);
                map.put(edge[1],curr);
            }
            indegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length;i++){
            if(indegree[i]==0){q.add(i);}
        }
        while(!q.isEmpty()){
            int current = q.poll();
            if(map.containsKey(current)){
                for(int n : map.get(current)){
                    indegree[n]--;
                    if(indegree[n] == 0){q.add(n);}
                }
            }
            else{
                continue;
            }
        }
        for(int i = 0; i < indegree.length;i++){
            if(indegree[i] >0)return false;
        }
        return true;
    }

    public static void main(String args[]){
        CourseSchedule obj = new CourseSchedule();
        System.out.println(obj.canFinish(6,new int[][]{{2,0},{1,0},{3,2},{4,2},{5,4},{5,3}}));
    }

}