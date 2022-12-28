# // Time Complexity : O(V+E)
# // Space Complexity : O(V+E)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

public class Solution {
    public bool CanFinish(int numCourses, int[][] pre) {
        Dictionary<int, List<int>> map = new Dictionary<int, List<int>>();
        var indegree = new int[numCourses];
        foreach (var edge in pre) {           
            indegree[edge[0]]++;
            if (!map.ContainsKey(edge[1]))
                map[edge[1]] = new List<int>();
            map[edge[1]].Add(edge[0]);
        }
        var q = new Queue<int>();
        int count = 0;
        for(int i = 0; i < numCourses; i++)
        {
            if(indegree[i] == 0){                
                q.Enqueue(i);
                count++;
            }
        }
        if(q.Count == 0) return false;
        while(q.Count > 0)
        {
            var curr = q.Dequeue();          
            var child = new List<int>();
            if(map.TryGetValue(curr, out child)){
                foreach(var c in child)
                {
                    Console.WriteLine(c);
                    indegree[c]--;
                    if(indegree[c] == 0)
                    {
                        q.Enqueue(c);
                        count++;
                    }
                }   
            }      
        }
        
        return count == numCourses;
    }
}
