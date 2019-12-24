/**
LeetCode Submitted : YES
Time Complexity : O(NUM COURSES)
Space Complexity : O(NUM COURSES)

The idea is to keep track of all the in-degrees nodes. Then create adjacency list based on pre-requisite array. Finally put the nodes which have in-degrees = 0 to the queue. While the queue is not empty pop the queue element and decrement indegrees array accordingly. if indegrees become zero add it to the queue. Once the queue is empty then check if all the indegrees value are equal to zero or not. The main trick is to create in-degrees array which was missing previously in my approach and caused issue.
**/


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length < 1)
            return true;
        
        int[] inDegrees = new int[numCourses];
        
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int[] pair : prerequisites){
            //Create in-degress array (like Topological Sort) //Important
            inDegrees[pair[1]] = inDegrees[pair[1]] + 1;
            
            //Create Adjacency List
            if(!adjList.containsKey(pair[0])){ //New Key in the HashMAP
                List<Integer> node = new ArrayList<>();
                node.add(pair[1]);
                adjList.put(pair[0],node);
            }
            else{
                
                List<Integer>  node1 = adjList.get(pair[0]);
                node1.add(pair[1]);
                adjList.put(pair[0],node1);
             
            }
                
          }
        
        System.out.println(adjList);
        
        //Start with initial position
        for(int i = 0; i< inDegrees.length; i++){
            if(inDegrees[i] == 0)
                q.add(i);
        }
        //q.add(prerequisites[0][0]);
        
        
        while(!q.isEmpty()){
            int currNode = q.poll();
            System.out.println(currNode);
            if(adjList.containsKey(currNode)){
                List<Integer> adjNodes = adjList.get(currNode);
                //Update in-degrees for each adjacent node
                for(int i : adjNodes){
                    inDegrees[i] = inDegrees[i] -  1;
                    if(inDegrees[i] == 0)
                        q.add(i);
                }
            }
        }
        
        //Check if all indegees are zero(satisfied)
        for(int i = 0; i< inDegrees.length; i++){
            //System.out.println(inDegrees[i]);
            if(inDegrees[i] != 0)
                return false;
        }
        
        return true;
        
    }
}
