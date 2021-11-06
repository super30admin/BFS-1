// 207 Course Schedule
// solved on leetcode
// Time Complexity -- n(V+E)
// Space complexity -- n(V+E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int [] dependencyList= new int[numCourses];
        
        for(int i=0;i<prerequisites.length;i++){
            dependencyList[prerequisites[i][0]]++;
        }
        
        
        List<List<Integer>> adjacencyList = new ArrayList();
        
        
        for(int i=0;i<numCourses;i++){
            adjacencyList.add(new ArrayList());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<dependencyList.length;i++){
            if(dependencyList[i]==0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int polled = queue.poll();
            
            List<Integer> dependentSubjects = adjacencyList.get(polled);
            
            for(int i=0;i<dependentSubjects.size();i++){
                dependencyList[dependentSubjects.get(i)]--;
                
                if(dependencyList[dependentSubjects.get(i)]==0){
                     queue.add(dependentSubjects.get(i));
                 }
            }
        }
        
        for(int i=0;i<numCourses ;i++ ){
            if( dependencyList[i]!=0){
                return false;
            }
        }
        return true;
        
    }
}