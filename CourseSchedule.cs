// Time Complexity : O(V+E), V i snumber of nodes or courses, E is edges (or dependency link) between courses
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// BFS approach, Hashmap
 public bool CanFinish(int numCourses, int[][] prerequisites) {
    if(prerequisites == null || prerequisites.Length == 0)
        return true;
    
    //dependency array
    int[] indegree = new int[numCourses];
    
    //map for course and dependent courses
    Dictionary<int, List<int>> dict = new Dictionary<int, List<int>>();
    
    foreach(int[] edge in prerequisites)
    {
        //first numbern in edhge is course which is dependent on another course
        indegree[edge[0]]++;
        //build map of course/courses which are depedent on it
        if(!dict.ContainsKey(edge[1]))
            dict.Add(edge[1], new List<int>());

        dict[edge[1]].Add(edge[0]);
    }

    //we can use count, to see if all courses has been taken
    //because count is increment by 1, when indegree[i] == 0
    int count = 0;
    //find course which has no depedency, that will be our starting point
    Queue<int> queue = new Queue<int>();
    for(int i = 0; i < numCourses; i++)
    {
        if(indegree[i] == 0)
        {
            queue.Enqueue(i);
            count++;
        }
    }
    
    //all courses are dependent on somehting, cycle, no coruse can be taken
    //return false
    if(queue.Count == 0)
        return false;
    
    while(queue.Count > 0)
    {
        int course = queue.Dequeue();
        //get all depedent courses
        if(dict.ContainsKey(course))
        {
            var edges = dict[course];
            //loop thru all depedent courses, decrease the dependency in indgree by 1
            //ass we took depedent course (pop or dequeue)
            //if indegree dependency is 0, it means this course is good to take, all dependency are taken
            //add it to queue
            foreach(var edge in edges)
            {
                indegree[edge]--;
                if(indegree[edge] == 0)
                {
                    queue.Enqueue(edge);
                    count++;
                }
            }
        }
    }
    
    return numCourses == count;
}