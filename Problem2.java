//Problem - Course Schedule
//Time Compplexity - O(m+n) // where m is number of prerequisites and n is number of courses
//Space Complexity - O(m+n) //// where m is number of prerequisites and n is number of courses
//Run code succssfully on Leetcode - Yes
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Creting HashMap to store course prerequisites
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] indegrees = new int[numCourses];
        for(int [] pr: prerequisites){
            int second = pr[1]; // courses that must be taken first
            int first = pr[0]; // courses depends on completion of second
            indegrees[first]++;
            if(!map.containsKey(second)){
                map.put(second, new ArrayList<>());
            }
            map.get(second).add(first);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        if(count == numCourses) return true;
        if(q.isEmpty()) return false;
        if(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> babies = map.get(curr);
            if(babies != null){
                 for(int baby: babies){
                indegrees[baby]--;
                if(indegrees[baby] == 0){
                    q.add(baby);
                    count++;
                }
            }
           
        }
    }
        return count  == numCourses;
    }
}