//time O(N+M) N is the size of prerequsites array and M is the size of indgrees array 
//space O(M+Q) M is the size of indegrees array, Q is the max size of queue while doing BFS
//approach: Create a hashmap from independent to dependant course and then create an indegrees array showing the dependiecies corresponding to index denoting course. Then do BFS start by pushing independent nodes from indegrees array. Keep reducing indegrees as the course if taken. In the end if indegrees is all zeroes return true.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length < 2) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] entry = prerequisites[i];
            if (!map.containsKey(entry[1])) {
                map.put(entry[1], new ArrayList<Integer>());
                map.get(entry[1]).add(entry[0]);
            } else {
                map.get(entry[1]).add(entry[0]);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            // int size = map.get(prerequisite[0]).size();
            indegrees[prerequisite[0]]++;
        }        
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }
        if (q.isEmpty()) return false;
        // int count = q.size();
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(map.containsKey(curr)) {
                for(int entry: map.get(curr)) {
                    indegrees[entry]--;
                    if (indegrees[entry] == 0) {
                        q.add(entry);
                        // count++;
                    }
                }                 
            }
        }
        for (int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] != 0) return false;
        }
        return true;
    }
}
