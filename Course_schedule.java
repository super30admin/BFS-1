//All test cases didn't pass

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Creating an adjacency list
        Map<Integer,List<Integer>> adj = new HashMap<>();
        
        //Indegrees to every node
        int[] indegree = new int[numCourses];
    //if(numCourses>prerequisites[0].length) return false;
        //Queue
        Queue<Integer> queue = new LinkedList<>(); 
        
        //Adding all the nodes to the list
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> list = adj.getOrDefault(prerequisites[i][1], new ArrayList<>());
            list.add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
            adj.put(prerequisites[i][1],list);
        }
        
        //Adding all the nodes with indegrees 0 to the queue
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        
        //Nowe we add all the adjacency nodes with indegrees 0 to the list
        int count=0;
        while(!queue.isEmpty()){
            int current = queue.poll();
                if(indegree[current]==0) count++;
                if(adj.containsKey(current)){
            for(int i=0;i<indegree.length;i++){
                indegree[i]--;
                if(indegree[i]==0) queue.add(i);
            }
        }
        }
        if(count==numCourses) return true; 
            else return false;
    }
} 
