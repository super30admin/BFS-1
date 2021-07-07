Time Complexity: O(E). E is number of dependencies
Space Complexity: O(n). n is number of courses
Ran successfully on leetcode?: yes

class Solution {
    HashMap<Integer, List<Integer>> map;
    int[] courses;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        courses = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<Integer>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            courses[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(courses[i] == 0) q.add(i);
        }
        bfsHelper(q);
        for(int i = 0; i < numCourses; i++){
            if(courses[i] > 0) return false;;
        }
        return true;
    }
    
    private void bfsHelper(Queue<Integer> q){
        while(!q.isEmpty()){
            int course = q.poll();
            if(map.containsKey(course)) {
            	int size = map.get(course).size();
	            for(int i = 0; i < size; i++){
	                courses[map.get(course).get(i)]--;
	                if(courses[map.get(course).get(i)] == 0){
	                    q.add(map.get(course).get(i));
	                }
	            }
            }
        }
    }
}
