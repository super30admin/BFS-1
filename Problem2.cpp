// Time Complexity : O(N) N is #of nodes in tree
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:
// 1. Traverse tree using BFS by creating an adjcency list representing tree.
// 2. Take indegrees array which stores #of nodes that current node is dependent on. 
// 3. While traversing push a node to be traversed only when it's indegrees value becomes 0.

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.empty()){
            return 1;
        }
        map<int,int> m;
        queue<int> q;
        map<int,vector<int>> adlist;
        for(int i=0;i<prerequisites.size();i++){
            vector<int> t=prerequisites[i];
            m[t[0]]++;
            if(m[t[1]]==0){
                m[t[1]]=0;
            }
            adlist[t[1]].push_back(t[0]);
           // cout<<adlist[t[1]][0];
        }
        for(const auto r:m){
            if(r.second == 0){
                q.push(r.first);
                //cout<<(r.first);
            }
            //cout<<r.second;
        }
        if(q.empty()){
            return 0;
        }
        while(!q.empty()){
            vector<int> temp=adlist[q.front()];
            for(int i=0;i<temp.size();i++){
                
                //cout<<temp[i]<<'\n';
                m[temp[i]]--;
                if(m[temp[i]]==0){
                    q.push(temp[i]);
                }
                if(m[temp[i]]<0){
                    return 0;
                }
                
            }
            q.pop();
        }
        for(const auto r:m){
            if(r.second != 0){
                return 0;
            }
        }
        return 1;
    }
};