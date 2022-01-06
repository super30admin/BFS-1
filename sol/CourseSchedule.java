package sol;


import java.util.*;

public class CourseSchedule {
public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int []ar= new int[numCourses];
          HashMap<Integer, ArrayList<Integer>> hm= new HashMap<>();
        
        //traverse on the prerequisite and populate the count of pre reqs for each course
        for( int i=0;i<prerequisites.length;i++){
            
                
         ar[prerequisites[i][0]]+=1;
            
            int x=prerequisites[i][0];
            int y=prerequisites[i][1];
            
            if(hm.containsKey(y)){
                
                hm.get(y).add(x);
            }else{
                ArrayList<Integer> al= new ArrayList<>();
                al.add(x);
                hm.put(y,al);
            }
                
          }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<ar.length;i++){
            
            if(ar[i]==0){q.add(i);}
        }
        
        while(!q.isEmpty()){
            
            int out=q.poll();
            if(!hm.containsKey(out)){
                
                
            }else{
            
            for(int it:hm.get(out)){
                ar[it]--;
                if(ar[it]==0){q.add(it);}
                
            }
            }
            
        }
        
         for(int i=0;i<ar.length;i++){
            
            if(ar[i]!=0){return false;}
        }
      
      
      
        
        
        return true;
        
        
    }
}
