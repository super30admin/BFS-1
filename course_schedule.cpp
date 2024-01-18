// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// We store all the prerequisites in a map(independent vs dependent). Then insert all dependent courses
// in to array and independent courses in queue. Next we iterate through all the entries from map and check 
// the count. 

#include <iostream>
#include <vector>
#include <queue>
class Solution {
public:
    bool canFinish(int numCourses, std::vector<std::vector<int>>& prerequisites) {
        std::unordered_map<int, std::vector<int>> adjList;
         std::vector<int> inDegree(numCourses);

        for(auto prereq: prerequisites)
        {
            int indep = prereq[1];
            int dep = prereq[0];
            
            inDegree[dep]++;

            adjList[indep].push_back(dep);
        }

        std::queue<int> q;
        int count = 0;
        for(int i = 0; i < numCourses; i++)
        {
            if(inDegree[i] == 0)
            {
                q.push(i);
                count++;
            }
        }

        if(count == numCourses)
        {
            return true;
        }

        if(q.empty())
        {
            return false;
        }

        while(!q.empty())
        {
            int currCourse = q.front();
            q.pop();
            if(adjList.find(currCourse) != adjList.end())
            {
                std::vector<int> children(adjList[currCourse]);
                for(int child : children)
                {
                    std::cout << child << std::endl;
                    if(--inDegree[child] == 0)
                    {
                        q.push(child);
                        count++;
                        if(count == numCourses)
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
};