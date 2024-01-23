// Time Complexity : O(V+E)

// Space Complexity : O(V+E)

// Did this code successfully run on Leetcode : YES

// Appoarch: Similar to graph prob. Making use of indegrees array to store the 
// the number of dependencies on each node. Using a map to store the independent and
// dependent nodes as we dont have to search the given array again and again, finally 
// a queue to keep track of the completed courses. If the indegrees becomes zero,
// all courses are completed.

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool canFinish(int numCourses, vector<vector<int>> &prerequisites)
    {
        map<int, vector<int>> mp;
        vector<int> indegrees(numCourses, 0);
        for (int i = 0; i < prerequisites.size(); i++)
        {
            int out = prerequisites[i][1]; // independent
            int in = prerequisites[i][0];  // dependent
            indegrees[in]++;
            if (mp.find(out) != mp.end())
            {
                mp[out].push_back(in);
            }
            else
            {
                mp[out] = {in};
            }
        }
        queue<int> q;
        int count = 0;
        for (int i = 0; i < numCourses; i++)
        {
            if (indegrees[i] == 0)
            {
                q.push(i);
                count++;
            }
        }
        if (q.empty())
            return false;
        while (!q.empty())
        {
            int curr = q.front();
            q.pop();
            if (mp.find(curr) != mp.end())
            {
                vector<int> children = mp[curr];
                for (int child : children)
                {
                    indegrees[child]--;
                    if (indegrees[child] == 0)
                    {
                        q.push(child);
                        count++;
                        if (count == numCourses)
                            return true;
                    }
                }
            }
        }
        return count == numCourses;
    }
};