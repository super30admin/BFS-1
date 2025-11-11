public class Solution {
    public bool CanFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        Dictionary<int, List<int>> adjList = new Dictionary<int, List<int>>();

        foreach (var p in prerequisites)
        {
            inDegrees[p[0]]++;
            if (!adjList.ContainsKey(p[1]))
                adjList[p[1]] = new List<int>();
            adjList[p[1]].Add(p[0]);
        }

        Queue<int> q = new Queue<int>();
        for (int i = 0; i < numCourses; i++)
        {
            if (inDegrees[i] == 0)
                q.Enqueue(i);
        }

        int count = 0;
        while (q.Count > 0)
        {
            int course = q.Dequeue();
            count++;

            if (adjList.ContainsKey(course))
            {
                foreach (var next in adjList[course])
                {
                    inDegrees[next]--;
                    if (inDegrees[next] == 0)
                        q.Enqueue(next);
                }
            }
        }

        return count == numCourses;
    }
}