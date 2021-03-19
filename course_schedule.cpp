// TC: O(V+E)where V is the num of courses and E is dependednt on the structure of the graph.
// SC: O(V+E)

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int>indegree(numCourses,0);
        unordered_map<int,vector<int>>umap;
        for(auto x: prerequisites){
            int from = x[1];
            int to = x[0];
            indegree[to]++;
            umap[from].push_back(to);
        }
        queue<int>q;
        for(int i = 0; i < indegree.size();i++){
            cout << indegree[i]<< endl;

            if(indegree[i]==0)q.push(i);
        }
        while(!q.empty()){
            int temp = q.front();q.pop();
            if(umap.find(temp)!=umap.end()){
            cout << temp;
            vector<int>t = umap[temp];
            for(auto x: t){
                cout << x;
                indegree[x]--;
                if(indegree[x]==0)q.push(x);
                }
            }
        }
        for(int i = 0; i < indegree.size();i++){
            if(indegree[i]!=0)return false;
        }
        return true;
        
        
        
    }
};