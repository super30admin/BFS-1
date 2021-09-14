// Time Complexity : O(∣E∣+∣V∣), ∣V∣ is the number of courses & ∣E∣ is the number of dependencies
// Space Complexity : O(∣E∣+∣V∣), ∣V∣ is the number of courses & ∣E∣ is the number of dependencies
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] list = new List[numCourses];
        
        for (int i=0; i<numCourses; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        for (int i=0; i<prerequisites.length; i++) {
            list[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        int[] check = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (!dfs(check,i, list)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(int[] check, int i, List<Integer>[] lt) {
        if (check[i] == 2) {
            return true;
        } else if (check[i] == 1) {
            return false;
        } else {
            check[i] = 1;
            for (int j=0; j<lt[i].size(); j++) {
                if (!dfs(check, lt[i].get(j), lt)) {
                    return false;
                }
            }
            check[i] = 2;
            return true;
        }
    }
}