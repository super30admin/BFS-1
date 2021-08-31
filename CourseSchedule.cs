public class Solution {
 
 //Time Complexity: O(V+E) graph
 //Space Complexity: O(V+E) graph
    public bool CanFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.Length == 0)
                return true;
            int[] indegrees = new int[numCourses];
            Dictionary<int, List<int>> map = new Dictionary<int, List<int>>();
            foreach (int[] edge in prerequisites){
                indegrees[edge[0]]++;
                if (!map.ContainsKey(edge[1]))
                {
                    map.Add(edge[1], new List<int>());
                }
                map[edge[1]].Add(edge[0]);
            }
            Queue<int> q = new Queue<int>();
            for (int i = 0; i < numCourses; i++)
            {
                if (indegrees[i] == 0)
                    q.Enqueue(i);
            }
            if (q.Count == 0) return false;
            int cnt = 0;
            while (q.Count != 0)
            {
                int curr = q.Dequeue();
                cnt++;
                List<int> edges = map[curr];
                if (edges != null)
                {
                    foreach (int edge in edges)
                    {
                        indegrees[edge]--;
                        if (indegrees[edge] == 0)
                        {
                            q.Enqueue(edge);
                        }
                    }
                }
            }
            return cnt == numCourses;
    }
  
}