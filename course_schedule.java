// because we deal with neighbour's neighbour's neighbour's ... hence bfs/dfs
// we are visiting each and everynode Time Complexity: O(V+E)
// Queue's length is the breath of graph - Space Complexity O(V+E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Adj List --> HashMap(easy to navigate what are connected values aka neighbours )
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] pr:prerequisites){
            //pr[1] --> Independent course
            //pr[0] --> Dependent course 
            // creating indegree array 
            indegrees[pr[0]]++;
            map.putIfAbsent(pr[1],new ArrayList<>());
            map.get(pr[1]).add(pr[0]); // adj list 0--><1,2>
        }
        //Get all independent values and add in Queue 
        Queue<Integer> q = new LinkedList<>(); // For BFS -- FIFO
        int count=0;
        for(int i=0;i<numCourses;i++){
                if(indegrees[i]==0){
                    q.add(i); // all independent courses 
                    count++; // counter to mantain how many courses in the queue
                }
            }
            if(q.isEmpty()) return false; // if queue is empty meaning no indep courses 
            if(count==numCourses) return true; 
            // if count reaches to all courses indicating all values are indep 
            // 1. Now we parse through each element in queue 
            // 2. Get dpenedent values and reduce indegrees - indicating we visited it 
            // 3. And adding in queue - meaning its indepenent now 
            while(!q.isEmpty()){
                int curr = q.poll();
                List<Integer> dependencies = map.get(curr);
                if(dependencies!=null){
                    for(int dep:dependencies){
                        indegrees[dep]--;
                        if(indegrees[dep]==0){
                            q.add(dep);
                            count++;
                            if(count==numCourses) return true;
                        }
                    }
                }
            }
            return false;
        }
    }
