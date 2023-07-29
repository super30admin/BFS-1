// Time Complexity : O(v+e)
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
//We will create a directed graph and then we will do a BFS in it. First we will have to start with the courses which do not have any prerequisites. 
//We will create a (1)hashmap to store the independent courses as keys and their dependendent courses as values and (2) an indegree array to keep the count of courses a particular course is dependent on. 
//The indegree array will be of the size of number of courses given. After creating the hashmap and the array, we will create a queue, to keep track to all the courses which get independent i.e completed. We will start from adding the courses which are independent in the beginning. Then check their dependent courses from their hashmap and reduce their counts in the indegrees array. 
//Whenever the count of any dependent course becomes 0, it is added to the queue and then we work on its dependent courses. We will keep a count of the courses which have become independent(complete), and if it is equal to the number of courses given, then we return true

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites==null || prerequisites.length==0) return true;
        //Hashmap to store the Independent and its dependent courses
       HashMap<Integer,List<Integer>> map=new HashMap<>();
       //Size of the indegree array has to equal to the number of courses
        int[] indegree= new int[numCourses];
        // we will go through all the array in the matrix prerequisites and create a hashmap and indegree array
        for(int[]pr:prerequisites)
        {
            //In the prerequisite matrix, each array has the dependent course at index 0 and independent at index1, so we increment the count of the dependent course in the indegree array
            indegree[pr[0]]++;

//if the map doesn't contain the independent course, we add it to the map and create a new array list for it
            if(!map.containsKey(pr[1]))
            {
                map.put(pr[1],new ArrayList<>());
            }
            // If the independent course is already present, we add the dependent course in its list
            map.get(pr[1]).add(pr[0]);
        }
//to keep the count of courses completed
int count=0;

//creating a queue to keep track of all the courses which get independent
Queue<Integer> q=new LinkedList<>();

for(int i=0;i<numCourses;i++)
{
    //if any element in the indegree array is 0 i.e independent, we add it to the queue
    if(indegree[i]==0)
    {
        q.add(i);   // Start the queue with this course
        count++;    //Increment the counter for the completed courses
    }
}

if(q.isEmpty()) return false; //if there are no independent courses, we return false

while(!q.isEmpty())
    {
        //pop the course from the queue
        int curr=q.poll();
        //look for the dependent courses in the hashmap and add it to the list
        List<Integer> dependent=map.get(curr);
     
if(dependent!=null)
{
//going through the dependent courses of the popped course
        for(Integer dep:dependent)
        {
            //decrement the count of the dependent course in the array
            indegree[dep]--;

            if(indegree[dep]==0)
            {
                //add the dependent courses which have become independent in the queue
                q.add(dep);
                //increment the count of completed courses
                count++;
            }
            if(count==numCourses) return true;
        }

    }
}
return false;       
    }
}
