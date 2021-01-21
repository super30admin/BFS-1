// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //have an array that holds the number of courses you will be taking to see whether you have finished the course or not
        int [] inArrow = new int[numCourses];
        //create a hash map so that we can get the vertices and their edges in O(1) time
        HashMap<Integer,List<Integer>> m = new HashMap<>();
        //loop through the prereqs array of arrays and populate the inArrow array with how many times a vertices has an incoming arrow
        for(int [] e : prerequisites){
            //take the first part of the array because [1,0] because 1 is dependent on 0. 0 --> 1. Then increment it by one since that is how mnay arrows are coming in.
            inArrow[e[0]]++;
            //now populate the hashmap with the second element in the array and make the ([0,1]) 0 the key and 1 the value because 0 is the vertex and one is the edge.
            if(!m.containsKey(e[1])){
                //if the map doesn't contain this vertex then make a new entry with this vertex and get it an array list as a value since we will be putting the edges in that list later
                m.put(e[1], new ArrayList<>());
            }
            //now put the edges in the list correspoinding to the vertext(key)
            m.get(e[1]).add(e[0]);
        }
        //now create the queue to be able to perform BFS
        Queue<Integer> que = new LinkedList<>();
        //intialize a counter that will see at the very end if the number of courses we processed in the BFS is equal to the # of courses
        int count = 0;
        //start a for loop that goes through the inArrow list to see which vertices are independent (they will have a value of 0), then add it to the queue. 
        for(int i = 0; i<inArrow.length; i++){
            if(inArrow[i] == 0){
                que.add(i);
            }
        }
        //start the while loop
        while(!que.isEmpty()){
            //now pull the first element in the queue that is our current vetex
            int cur = que.poll();
            //now a class has been complete when you pull from the queue so increase the count
            count++;
            //now find the cur's edges it will be an array
            List<Integer> temp = m.get(cur);
            //check if the node doesn't have edges 
            if(temp != null){
                //loop through the edges in the array
                for(int e : temp){
                    //decrease the incoming arrows to the edge in the inArrow since you have compelted one prereq
                    inArrow[e]--;
                    //if that value in the inArrow array becomes 0 means that you have completed another course and so you add it to the queue
                    if(inArrow[e] == 0){
                        que.add(e);
                    }
                }
            }
        }
        //if the count is equal to the # of courses then you finished all the courses return true, else return false
        if(count == numCourses) return true;
        return false;
    }
}