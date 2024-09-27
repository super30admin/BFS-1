//time complexity:O(V+E)
//space complexity:O(n)
//executed on leetcode: yes
//approach: finding cycle in graph
//any issues faced? yes, saw the solution then executed it

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int>indegree(numCourses,0);
        queue<int>q;
        for(int i=0; i<prerequisites.size(); i++)
        {
            indegree[prerequisites[i][0]]++;
        }
        for(int i=0; i<numCourses; i++)
        {
            if(indegree[i]==0)
            {
                q.push(i);
            }
        }
        int count=0;
        while(!q.empty())
        {
            int vertex=q.front();
            q.pop();
            for(int i=0; i<prerequisites.size(); i++)
            {
                
                if(prerequisites[i][1]==vertex)
                {
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]]==0)
                    {
                        q.push(prerequisites[i][0]);
                    }
                }
            }
            count++;
        }
        if(count==numCourses)
            return true;
        else
            return false;
    }
};