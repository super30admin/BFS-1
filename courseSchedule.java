// Time Complexity: O(V+E) as we are checking which is having maximum, either if all are independent there are no edges and all nodes can go inside queue and get returned. else if every node is connected to other E will be n*n edges, which will ignore V so we take O(V+E)
// Space Complexity: Again based on Vertices and Edges => O(V+E)
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach here
// Idea here is to create a mapping of each course in respect to the current course 
// by adding them to a list in a map, there by creating an Adjacency list
// Along with this we are maintaining an indegree which holds each course as index and
// how many courses it depends on providing an insight if all the dependency course been completed
// now using fifo structure(queue) we can start with all the subjects which are independent to take
// on polling the subject, we reduce indegrees dependency count for all the child courses
// and check if the child course have become independent to take we add them to queue
// however we do not add child course to queue if there are any other dependencies remaining
// at the end when queue gets empty, if there are any courses in indegrees whose dependency
// is greater than 0, course schedule can not be completed

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] arr = new int[numCourses];
        for(int[] req: prerequisites) {
            arr[req[0]]++;
            if(!map.containsKey(req[1])) {
                map.put(req[1], new ArrayList<>());
            }
            map.get(req[1]).add(req[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==0) {
                q.offer(i);
                count++;
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> reductions = map.get(curr);
            if(reductions!=null) {
                for(int child: reductions) {
                    arr[child]--;
                    if(arr[child]==0) {
                        q.offer(child);
                        count++;
                    }
                }
            }
        }
        return (count==numCourses);
    }
}