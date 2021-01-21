
//Time Complexity:O(V+E)
//Space Complexity: O(V)
public class Solution2 {
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        int [] indegree= new int[numCourses];
	        HashMap<Integer,List<Integer>> map = new HashMap<>();
	        for(int[] edges: prerequisites){
	            indegree[edges[0]]++;
	            if(!map.containsKey(edges[1])){
	                map.put(edges[1], new ArrayList<>());
	            }
	            map.get(edges[1]).add(edges[0]);
	        }
	        Queue<Integer> que = new LinkedList<>();
	        int count =0;
	        for(int i=0;i<indegree.length;i++){
	            if(indegree[i] == 0){
	                que.add(i);
	            }
	        }
	        while(!que.isEmpty()){
	            int curr = que.poll();
	            count++;
	           List<Integer> edges = map.get(curr);
	            if(edges!=null){
	                for(int edge: edges){
	                    indegree[edge]--;
	                    if(indegree[edge]==0){
	                        que.add(edge);
	                    }
	                }
	            }
	        }
	        if(count != numCourses)return false;
	    return true;
	    }
}
