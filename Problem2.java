package BFS1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 
 * Using BFS with the help of a Queue to identify independent nodes and then process them to remove the dependency 
 * other courses may have on them. 
 * 
 * Time Complexity : O(n) where n is the length of prerequisites
 * 
 * 
 * Space Complexity : O(n) since we use a queue
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)
            return true;
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        int[] dependentCount= new int[numCourses];
        Queue <Integer> q=new LinkedList<>();
        for(int i=0;i<prerequisites.length;i++){
            if(!map.containsKey(prerequisites[i][1])){
                List<Integer> li = new ArrayList<>();
                map.put(prerequisites[i][1], li);
            }

            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            dependentCount[prerequisites[i][0]]=dependentCount[prerequisites[i][0]]+1;
        }

        for(int i=0;i<dependentCount.length;i++){
            if(dependentCount[i]==0){
                q.add(i);
            }}


        while(!q.isEmpty()){
            int curr=q.poll();
            List<Integer> dependents= map.get(curr);
            if(dependents!=null){

                for(Integer ele : dependents){
                dependentCount[ele]=dependentCount[ele]-1;
                if(dependentCount[ele]==0)
                    q.add(ele);
            }

            }

        }

        for(int i=0;i<dependentCount.length;i++){
            if(dependentCount[i]!=0){
                return false;
            }
        }
        return true;
    }

}
