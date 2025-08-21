
//Time Complexity: O(n + e) where n is the number of courses and e is the number of prerequisites
//Space Complexity: O(n + e) for the adjacency list and indegree array


//We will use an adjacency list to represent the graph
//We will use an indegree array to keep track of the number of prerequisites for each course
//We will use a queue to perform BFS on the graph
//We will continue this process until we have processed all courses or found a cycle

class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int indegree[]=new int[n];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();

        for(int[] pr : prerequisites){
            indegree[pr[0]]++;
            if(!map.containsKey(pr[1])){
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
        }

        //add in queue only when indegree is 0
        int count=0;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
            }
        }

        if(count==n) return true;
        if(q.isEmpty()) return false;
        
        while(!q.isEmpty()){
            int curr=q.remove();
            List<Integer> dependencies=map.get(curr);   //get the curr node neighbors from the adjacency list
            if(dependencies!=null){
                for(int dep:dependencies){
                    indegree[dep]--;
                    if(indegree[dep]==0){
                        q.add(dep);
                        count++;
                        if(count==n)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}