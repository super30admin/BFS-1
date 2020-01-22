Time Complexity-O(V*E) where V is number of vertices and E is number of Edges.
Space Complexity-O(V+E)
Did the code run on Leetcode? Yes

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int>m(numCourses,0);
        unordered_map<int,vector<int>>k;
        queue<int>temp;
        for(int i=0;i<prerequisites.size();i++)
        {
             m[prerequisites[i][0]]++;
             if(k.find(prerequisites[i][1])==k.end())
            {
                k[prerequisites[i][1]]={};
            }
            k[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
         for(int i=0;i<m.size();i++)
         {
             if(m[i]==0)
             {
                 temp.push(i);
             }
         }
        while(!temp.empty())
        {
            int a=temp.front();
            temp.pop();
            vector<int>b=k[a];
            if(b.size()>0)
            {
                for(int i=0;i<b.size();i++)
                {
                    m[b[i]]--;
                    if(m[b[i]]==0)
                    {
                        temp.push(b[i]);
                    }
                }
            }
        }
        for(int i=0;i<m.size();i++)
        {
            if(m[i]>0)
            {
                return false;
            }
        }
        return true;
    }
};