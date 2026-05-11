class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        queue<int> q;
        int count=0;
        unordered_map<int, vector<int>> map;
        vector<int> inorder(numCourses, 0);

        for(int i=0;i<prerequisites.size();i++)
        {
            inorder[prerequisites[i][0]]++;
            map[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        for(int i=0;i<inorder.size();i++)
        {
            if(inorder[i]==0)
            {
                  q.push(i);
                  count++;
            }
              
        }
        if(q.empty())
            return false;
        while(!q.empty())
        {
            int node=q.front();
            q.pop();
            for(auto [key,val]: map)
            {
                if(key==node)
                {
                    for(auto x: val)
                    {
                        inorder[x]--;
                        if(inorder[x]==0)
                        {
                             q.push(x);
                             count++;
                        }
                           
                    }
                }
            }
        }
return count==numCourses;
    }
};
