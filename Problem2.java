
public class Problem2 {
	
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
	      
	        
	        Map<Integer,List<Integer>> adlist= new HashMap<Integer,List<Integer>>();
	        
	        int[] indegree= new int[numCourses];
	        int[] topoorder= new int[numCourses];
	        
	        for(int[] arr : prerequisites){
	            int dest=arr[0];
	            int src=arr[1];
	            
	            List<Integer> adj = adlist.getOrDefault(src,new ArrayList<Integer>());
	         
	            
	            adj.add(dest);
	            adlist.put(src,adj);
	            indegree[dest]++;
	        }
	        
	        
	        Queue<Integer> q= new LinkedList<>();
	        
	        for(int i=0;i<numCourses;i++){
	            if(indegree[i]==0){
	                q.add(i);
	            }
	        }
	        
	        int i=0;
	        
	        while(!q.isEmpty()){
	            int node=q.remove();
	            topoorder[i++]=node;
	            
	            if(adlist.containsKey(node)){
	                for(int neigh : adlist.get(node)){
	                indegree[neigh]--;
	                    if(indegree[neigh]==0){
	                        q.add(neigh);
	                    }
	                }
	            }
	            
	        }
	        
	        if(i==numCourses){
	            return topoorder;
	        }
	        
	        return new int[0];
	    }
	
}
