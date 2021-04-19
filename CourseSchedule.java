/**Leetcode Question - 207 - Course Schedule */
/**Algorithm -BFS
 * Make an inorder array to store the degree of each subject
 * Create a hashmap with the sub as key and its dependents in the list
 * Create a queue and push the subjects with indegree 0 in it
 * Subtract 1 from the dpendent subject when a subject is pulled out from the queue
 * Check if the inorder array has any element>0, return false else true;
 */
/**TC- O(V+E) V= number of courses, E= direction of dependencies(prerequisities) 
 * SC - O(V+E) Hahmap contains both the vetrex and the edges list
 */
public class CourseSchedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if(numCourses == 0){
                return true;
            }
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            int[] inorder = new int[numCourses];
            
            for(int[] edge : prerequisites){
                inorder[edge[0]]++;
                if(!map.containsKey(edge[1])){
                    map.put(edge[1], new ArrayList<>());
                }
                map.get(edge[1]).add(edge[0]);
            }
            Queue<Integer> q = new LinkedList<>();
            
            for(int i=0; i<inorder.length; i++){
                if(inorder[i] == 0){
                    q.add(i);
                }
            }
            int cnt =0;
            while(!q.isEmpty()){
                int curr = q.poll();
                cnt++;
                List<Integer> edges = map.get(curr);
                if(edges!= null){
                    for(int edge: edges){
                        inorder[edge]--;
                        if(inorder[edge] == 0){
                            q.add(edge);
                        }
                    }
                }
            }
            return cnt == numCourses;
        }
    }
}
