public class CourseSchedule
    {
        // Time Complexity : O(V + E) - V is all vertices/courses and E is all edges/dependencies
        // Space Complexity : O(V + E) - V is all vertices/courses and E is all edges/dependencies and hashmap is used as auxiliary space 
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public bool CanFinish(int numCourses, int[][] prerequisites)
        {
            Dictionary<int, List<int>> map = new Dictionary<int, List<int>>();
            int[] indegrees = new int[numCourses];
            foreach (var pr in prerequisites)
            {
                //        incoming <- outgoing
                //(1,0) :   1      <-   0
                int incoming = pr[0]; //dependent
                int outgoing = pr[1]; //independent

                indegrees[incoming]++;
                if(!map.ContainsKey(outgoing))
                {
                    map.Add(outgoing, new List<int>());
                }
                map[outgoing].Add(incoming);
            }

            int count = 0;
            Queue<int> q = new Queue<int>();

            //first go over indegrees array to get all independent nodes (0) and add it to Queue
            for(int i = 0; i < indegrees.Length; i++)
            {
                if(indegrees[i] == 0)
                {
                    q.Enqueue(i);
                    count++;
                }
            }

            if (count == numCourses) return true; // if everything is independent and no edges

            if (q.Count == 0) return false; // if everything is dependent upon each other nothing goes in queue

            while(q.Count > 0)
            {
                //size not required as we are not calculating how many semesters
                int curr = q.Dequeue();
                if (map.ContainsKey(curr))
                {
                    List<int> dependencies = map[curr];
                    if (dependencies.Count > 0)
                    {
                        foreach (var dependent in dependencies)
                        {
                            indegrees[dependent]--;
                            if (indegrees[dependent] == 0)
                            {
                                q.Enqueue(dependent);
                                count++;
                                if (count == numCourses) return true; //we can finish the BFS early and leave the other elements in queue
                            }
                        }
                    }
                }
            }
            return count == numCourses;
        }
    }
