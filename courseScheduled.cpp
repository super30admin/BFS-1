// Time Complexity :O(V+E) -> Vertex and Edges
// Space Complexity : O(V+E)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> inDegree(numCourses,0);
        unordered_map<int,vector<int>> hMap;
        queue<int> q;
        int in,out;
        for(auto pre: prerequisites){
            in = pre[1];
            out = pre[0];
            hMap[out].push_back(in);
            inDegree[in]++;
        }
        /*for(auto c: hMap){
            cout<<c.first<<":";
            for(auto s : c.second){
                cout<<s<<",";
            }
            cout<<endl;
        }*/
        for(int i=0;i<inDegree.size();i++){
            if(inDegree[i] == 0)
                q.push(i);
        }
        if(q.empty()) return false;
        int temp;
        while(!q.empty()){
            temp = q.front();
            q.pop();
            //if(hMap[temp].size() == 0) continue;
            for(auto c : hMap[temp]){
                inDegree[c]--;
                if(inDegree[c] == 0) q.push(c);
            }
        }
        for(int c : inDegree){
            if(c != 0) return false;
        }
        return true;
    }
};