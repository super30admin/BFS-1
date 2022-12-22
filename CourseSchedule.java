class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for(int [] edge:edges){
            indegrees[edge[0]]++; // Topological List

            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>()); // HashMap

            }
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 0; i< numCourses ; i++){// Checking Independent Courses
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){//reduce Indegrees of babies 
            int curr = q.poll();

            List<Integer> children =map.get(curr);
            if(children != null){
               for(int child: children){
                indegrees[child]--;
                if(indegrees[child] == 0){
                    q.add(child);
                    count++;
                    if(count == numCourses) return true;
                }
            }
            }
            
        }
        return count == numCourses;
    }
}





//***
//TC - O(E + V)
//SC - O(N)

// Approach : 
// 1.Here We need to start with Independent courses first. 
// 2.By taking indegrees array we can count all the edges and at the same time we will assign dependent courses in a list to indepedenet courses inside hashmap. 
// 3.To make search O(1). Creating a queue and adding all Independent courses inside indegrees array to queue.
// 4. We can reduce dependency  By taking first independent course from queue and reducing there dependency count inside indegree array.
//5. When my count matches with numberofcourses we can return true.






 */