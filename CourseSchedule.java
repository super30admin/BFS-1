// Space: O(V+E)
// Time: O(V+E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        
        for(int [] prereq:prerequisites){
            int in=prereq[0];
            int out=prereq[1];
            indegree[in]++;
            if(!map.containsKey(out)){
                map.put(out,new ArrayList<>());
            }
            map.get(out).add(in);
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);   
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int course=q.poll();
            count++;
            if(map.get(course)!=null){
                Iterator<Integer> i=map.get(course).iterator();
                while(i.hasNext()){
                    Integer val=i.next();
                    indegree[val]--; // One dependency is finishes since that course is being taken from queue
                    if(indegree[val]==0){
                        q.add(val);
                    }
                }   
            }
        }
        if(count!=numCourses) return false;
        return true;
    }
}