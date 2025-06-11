/*
  Time complexity:O(V+E)
  Space complexity:O(V+E)

  Code ran successfully on Leetcode: Yes
*/

public class Solution {
    public bool CanFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Dictionary<int,List<int>> dict = new();
        Queue<int> queue = new();
        int count = 0;

        foreach(var p in prerequisites)
        {
            if(!dict.ContainsKey(p[1]))
                dict.Add(p[1],new List<int>());

            dict[p[1]].Add(p[0]);
            indegree[p[0]]++;
        }

        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                queue.Enqueue(i);
                count++;
            }
        }

        while(queue.Count>0)
        {
            int size = queue.Count;
            for(int i=0;i<size;i++)
            {
                int temp = queue.Dequeue();
                if(dict.ContainsKey(temp))
                {
                    foreach(var t in dict[temp])
                    {
                        indegree[t]--;
                        if(indegree[t]==0)
                        {
                            queue.Enqueue(t);
                            count++;
                        }
                    }
                }
            }
        }

        if(count==numCourses)
            return true;
        else
            return false;
    }
}
