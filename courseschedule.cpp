//T :O(V+E) 
//S: O(V+E) 
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.size() == 0) return true;
        map<int, vector<int>> adjList;
        vector<int> incomEdges(numCourses, 0);
        for(auto i : prerequisites){
            int first = i[0];
            int second = i[1];
            incomEdges[first]++;
            if(adjList.find(second) == adjList.end()){
                vector<int> x;
                adjList[second] = x;
            }
            adjList[second].push_back(first);
        }
        queue<int> qu;
        for(int i=0; i<incomEdges.size(); i++){
            if(incomEdges[i] == 0){
                qu.push(i);
            }
        }
        if(qu.empty()) return false;
        while(!qu.empty()){      
            int x = qu.front(); qu.pop();
            for(auto i: adjList[x]){
                if(--incomEdges[i] == 0) qu.push(i);
            }          
            
        }
        for(int i=0; i<incomEdges.size(); i++){
            if(incomEdges[i] > 0) return false;
        }
        return true;
        
        
        
        
        
        
        
    }
};