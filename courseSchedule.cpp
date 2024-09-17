// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
public:
    bool canFinish(int n, vector<vector<int>>& p)
    {
      vector<int> v[n];
        
        for(int i=0;i<p.size();i++)
        {
            v[p[i][1]].push_back(p[i][0]);
        }
        
        int inorder[n]={0};
        
        for(int i=0;i<n;i++)
        {
            for(auto x:v[i])
            {
                inorder[x]++;
            }
        }
        
        queue<int> q;
        
        for(int i=0;i<n;i++)
        {
            if(inorder[i]==0)
            {
                q.push(i);
            }
        }
        int count=0;
        while(!q.empty())
        {
            int node=q.front();
            q.pop();
            count++;
            for(auto x:v[node])
            {
                inorder[x]--;
                if(inorder[x]==0)
                {
                    q.push(x);
                }
            }
        }
        
        if(count!=n)
            return false;
        return true;
    }
};