//Time Complexity:
//Space Complexity:
//running on leetcode: yes

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       //base case, no courses it is null return true
        if (prerequisites==null || prerequisites.length==0)
        {
            return true;
        }
        //indegrees array to record, dependancies each course has, length is #courses
        //indices of the array represent the nodes
        int[] indegrees = new int [numCourses];
        //create hashmap (adjacency list representation): k=course, v=list of courses dependant on the course HashMap<Integer<List<Integer>>>
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //iterate the prerequisites array and update the values of indegrees array and populate the hashmap
        //each entry of the pre-req array is an edge
        for (int[] edge: prerequisites)
        {
            //edge[1] is prereq for edge[0] for each entry
            //ex: for edge[1,0], edge[0]=0 edge[1]=1, indegree[edge[0]]=0 (at index 0)
            //increase indegree of this index by 1
            indegrees[edge[0]]++;
            //hashmap entry
            //node doesnt exist
            if (!map.containsKey(edge[1]))
            {
                //enter edge[1] in map and emtry list to store dependants
                map.put(edge[1], new ArrayList<>());
            }
            //put edge[0] in the list of values for edge[1]
            map.get(edge[1]).add(edge[0]);
        }
        //BFS
        //create a queue, data type is integer coz courses are represented by integer
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<numCourses; i++)
        {
            //System.out.println(i);
            if (indegrees[i]==0)
            {
                q.add(i);
            }
        }
        //nothing went into the queue, no courses can be taken
        if (q.size()==0)
            {
                return false;
            }
        //when q is not empty
        int count = 0;
        while (!q.isEmpty())
            {
                //get the current node out
                int curr = q.poll();
                //increase count by 1 everytime one element is popped out (one course is completed)
                count++;
                //from map check dependant courses of the popped out course
                //edges is the list of dependant courses
                List<Integer> edges = map.get(curr);
                //the value list is not null for the popped course
                if (edges != null)
                {
                    //indegree value of this dependant courses from the value list
                    for (int edge:edges)
                    {
                        //one prereq is done so decrease by 1
                        indegrees[edge]--;
                        //prereqs becomes 0 add to queue
                        if (indegrees[edge] == 0)
                        {
                            q.add(edge);
                        }
                    }
                }
            }
            //only completed courses are popped
            //if the courses popped == numcourses, means all courses are complete
        return count==numCourses;
    }
}
