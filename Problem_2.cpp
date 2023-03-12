207. Course Schedule


//Kahn's Algorithm
// TC O(V+E)
// SC O(V+E)

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        //create an adjacency list
        unordered_map<int,list<int>> adj;
        vector<int> indegree(numCourses);
        int count = 0;
        for(int i = 0 ; i < prerequisites.size() ; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj[u].push_back(v);
		//step 1 : find indegree for each node
            indegree[v]++;
        }


        //step 2 : add elements with indegree = 0 to a queue
        queue<int> q;
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0) {
                q.push(i);
                count++;
            }

        }

        vector<int> ans;
        //step 3 : apply BFS
        while(!q.empty()){
            int front = q.front();
            q.pop();

            ans.push_back(front);

            //update indegree of the neighbours
            for(auto i : adj[front]){
                indegree[i]--;
                if(indegree[i] == 0) {
                    q.push(i);
                    count++;
                }
                if (count == numCourses) return true;
            }
        }

        //step 4 : 
        if (count == numCourses) return true;
            return false;
    }
};

