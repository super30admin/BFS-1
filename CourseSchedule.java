// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using Toplogical sort. Created an indegrees array to maintain the count of dependent nodes, hashmap where key will be the independent nodes & value will be list of dependent nodes. Stared by adding the non-dependent nodes in the queue and then if in idegrees array value is 0 add to the queue and with the count variable check if it equals to number of courses.
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses == 0){
            return false;
        }

        int[] indegrees = new int[numCourses]; //O(V)
        HashMap<Integer, List<Integer>> map = new HashMap<>(); //Adjacency List //O(v+E)
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        //O(V + E)
        for(int[] prerequisite : prerequisites ){
            int from = prerequisite[1]; //independent node
            int to = prerequisite[0]; //dependent node
            indegrees[to]++;

            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
            }

            map.get(from).add(to);
        }

        for(int i =0; i<indegrees.length; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int i =0; i<size; i++){
                int curr = q.poll();

                if(!map.containsKey(curr)){
                    continue;
                }

                List<Integer> edges = map.get(curr);

                for(int edge : edges){
                    indegrees[edge]--;

                    if(indegrees[edge] == 0){
                        q.add(edge);
                        count++;
                    }
                }

            }
        }

        if(count != numCourses){
            return false;
        }

        return true;
    }
}