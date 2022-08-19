//TC: O(n)
//SC: O(n)
//leetcode: successful

class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] indegrees= new int[numCourses];
        for(int [] edge: edges){
            indegrees[edge[0]]++; //this is the list which stores the dependencies of each edge i.e each number  ; [a,b]
            //independent to dependent
            if(!map.containsKey(edge[1])) {
                map.put(edge[1],new ArrayList<>()); //making sure every independent node has a list belonging to it, if it doesn't have                
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){ //add independent nodes 
                q.add(i);
                count++;
            }
        }
            if(q.isEmpty()){ //if no independent node
                return false;
            }
            if(count==numCourses) return true; //if all the courses are done
            while(!q.isEmpty()){
                int curr=q.poll(); //taking the course out
                //reduce independency - the indegrees of babies
                List<Integer> children=map.get(curr);
                if(children != null){
                for(int child: children){
                    indegrees[child]--;
                    if(indegrees[child]==0){ //if the child becomes zero, and it won't happen always
                        q.add(child);
                        count++;
                        if(count==numCourses) return true; // if all courses are equal
                    }
                }
            } 

        }
        return false;
    }
} 