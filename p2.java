// Time Complexity : O(v + e) vertices and edges
// Space Complexity : O(v + e)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


//Prereq is the edges array
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //Indegreees array
        int[] arr = new int[numCourses];

        //Map to keep track of edges
        Map<Integer,List<Integer>> map = new HashMap<>();

        //Queue to process the courses which have completed prereq
        Queue<Integer> q = new LinkedList<>();

        int size = prerequisites.length;

        //Loop to fill indegrees array and also to fill map
        for(int i=0; i<size; i++){
            int[] pre = prerequisites[i];
            arr[pre[0]]++;
            if(!map.containsKey(pre[1])){
                map.put(pre[1], new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
        }
        
        int cnt = 0;
//Loop to add the courses in queue with no prereq
        for(int i=0; i<numCourses; i++){
            if(arr[i] == 0) {
                q.add(i);
                
                cnt++;
            }
        }
if(cnt == numCourses) return true;

//Loop to process the courses in queue and to add new courses in queue with completed prereq
        while(q.peek() != null){
            if(cnt == numCourses) return true;
            int temp = q.remove();
            List<Integer> list = map.get(temp);
            if(list != null){
                for(int i=0; i<list.size(); i++){
                temp = list.get(i);
                arr[temp]--;
                if(arr[temp] == 0){
                    q.add(temp);
                    cnt++;
                    
                    if(cnt == numCourses) return true;
                }
            }
            }
            
        }
if(cnt == numCourses) return true;
        return false;

    }
}