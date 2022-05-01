using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class CourseSchedule
    {
        /*
         * T.C: O(V+E) V is number of courses and E is edges in the prerequisites
         * S.C: O(V+E) V is number of courses and E is edges in the prerequisites
         * 
         */
        public bool CanFinish(int numCourses, int[][] prerequisites)
        {
            int[] indegree = new int[numCourses];
            Dictionary<int, List<int>> map = new Dictionary<int, List<int>>();
            
            foreach (var edge in prerequisites)
            {
                indegree[edge[0]]++;
                if (!map.ContainsKey(edge[1]))
                {
                    map.Add(edge[1], new List<int>());
                }
                Console.WriteLine(edge[1]);
                map[edge[1]].Add(edge[0]);
            }

            int count = 0;
            Queue<int> queue = new Queue<int>();

            for (int i = 0; i < numCourses; i++)
            {
                if (indegree[i] == 0)
                {
                    queue.Enqueue(i);
                    count++;
                }
            }

            if (queue.Count == 0) return false;


            while (queue.Count != 0)
            {
                int curr = queue.Dequeue();
                if (map.ContainsKey(curr))
                {
                    var lst = map[curr];
                    if (lst != null)
                    {
                        foreach (var edge in lst)
                        {
                            indegree[edge]--;
                            if (indegree[edge] == 0)
                            {
                                queue.Enqueue(edge);
                                count++;
                            }
                        }
                    }
                }
            }

            return count == numCourses;

        }
    }
}
