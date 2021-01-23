// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : took some time to understand problem


// Your code here along with comments explaining your approach

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] inEdges = new int[numCourses];


        //store vertices and edges in hashmap
        HashMap<Integer,List<Integer>> mp = new HashMap<>();

        //count incoming edges for every node
        for(int[] edges: prerequisites){
            inEdges[edges[0]]++;

            if(!mp.containsKey(edges[1])){

                mp.put(edges[1], new ArrayList<>());

            }

            //add edges corresponding to node
            mp.get(edges[1]).add(edges[0]);

        }

        //BFS
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < inEdges.length; i++){
            if(inEdges[i] == 0){
                q.add(i);
            }
        }

        //count
        int c = 0;

        while(!q.isEmpty()){
            //get first node from queue
            int curr = q.poll();

            c++;
            //get its edges
            List<Integer> temp = mp.get(curr);

            if(temp != null){
                //loop thru its edges and decrease the num of incoming edges for every node until 0
                for(int edge: temp){
                    inEdges[edge]--;

                    if(inEdges[edge] == 0){
                        q.add(edge);
                    }


                }

            }
        }
        //if incoming edges were equal to allowed numCourses
        if(c == numCourses) return true;


        return false;
    }
}