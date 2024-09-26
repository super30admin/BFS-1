/**
 * TC : O(V + E) SC : O(V + E)
 * Approach : Given list of edges maintain inDegrees for each and every course in an array,
 *            build map for each course that can be taken if we take current course,
 *            BFS on the generated graph by adding the indices with 0 inDegrees to queue and maintaining their inDegree after they are processed,
 *            at end check if the inDegree array is empty, if not return false.
 */
//x depends on y
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            // System.out.println(prerequisites[i][0]);
            inDegree[prerequisites[i][0]] += 1;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1],new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){
             // System.out.println(i +" : "+inDegree[i]);
            if(inDegree[i] == 0) q.add(i);
        }
        // System.out.println(q.peek());
        while(!q.isEmpty()){            
            List<Integer> temp = new ArrayList<>();
            temp = map.get(q.poll());
            if(temp != null){    
                for(int i = 0; i < temp.size(); i++){
                    inDegree[temp.get(i)]--;
                    if(inDegree[temp.get(i)] == 0) q.add(temp.get(i));
                }
            }
        }
        
        for(int i = 0; i < inDegree.length; i++){
            // System.out.println(i +" : "+inDegree[i]);
            if(inDegree[i] > 0) return false;
        }
        return true;
    }
}