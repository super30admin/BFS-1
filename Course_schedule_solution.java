package codes;

public class Course_schedule_solution {

	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        int []indegree= new int[numCourses];
	        
	        HashMap<Integer, List<Integer>> map= new HashMap<>();
	        
	        
	        for (int [] sub:prerequisites){
	            indegree[sub[0]]++;
	            if (!map.containsKey(sub[1])){
	                map.put(sub[1],new ArrayList<>());
	            }
	            map.get(sub[1]).add(sub[0]);
	        }
	        
	        
	        Queue<Integer> q = new LinkedList<>();
	        
	        
	        for(int i=0;i<indegree.length;i++){
	            if(indegree[i]==0){
	                q.add(i);
	            }
	        }
	        
	        while (!q.isEmpty()){
	            int curr=q.poll();
	            List<Integer> children =map.get(curr);
	            if (children!=null){
	                for (int child:children){
	                    indegree[child]--;
	                    if(indegree[child]==0){
	                        q.add(child);
	                    }
	                }
	            }
	        }
	        
	        
	        for(int i=0;i<numCourses;i++){
	            if(indegree[i]>0){
	                return false;
	            }
	            
	        }
	        return true;
	    }
}
