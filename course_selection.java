//Time complexity:O(m+n)
//Space complexity:O(m+n) 
//Solved steps:traverese numcourse and put the element in hashmap 
//increase the indegree by 1
//now perform the BFS add the courses with indegrees==0 this means course has no prerequisute 
//then check for same as key in hasmap and reduce its indegree
//if indegree==0 the add in queue and traverse q till its empty
//once all the elements are traverse with indegree==0 and hashmap 
//check if all values in indegree==0 and return true else false

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0){
            return false;
        }
        int[] indegrees=new int[numCourses];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int[] prerequisite: prerequisites ){
            int to =prerequisite[0];
            int from= prerequisite[1];
            indegrees[to]++;
            if(!map.containsKey(from))
            {
                map.put(from,new ArrayList<>());
            }
            map.get(from).add(to);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
            }}
            if(q.isEmpty()){
                return false;
            }
            while(!q.isEmpty()){
                int curr=q.poll();
                List<Integer> edges=map.get(curr);
                if(edges==null){
                    continue;
                }
                for(int edge:edges){
                    indegrees[edge]--;
                    if(indegrees[edge]==0){
                        q.add(edge);
                    }
                }

            }
            for( int i=0;i<indegrees.length;i++){
                if(indegrees[i]!=0){
                    return false;
                }
            }
            return true;
        
    }
}