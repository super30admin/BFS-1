class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {

            map<int,list<int>> adjlist;

            int indegree[numCourses] ;
        for (int i = 0; i < numCourses; i++) {
              indegree[i] = 0;
                    }

    //  for(int i=0;i<prerequisites.size();i++){
    //         int u=prerequisites[i][0], v=prerequisites[i][1];
    //         adjlist[v].push_back(u);
    //         indegree[u]++;
    //     }

        if(prerequisites.size() == 0){
            return true;
        }


            for(auto arr:prerequisites){
                cout<< arr[0] ; 
                indegree[arr[0]]++;
                cout<<indegree[arr[0]]<<"  ";
                if(adjlist.find(arr[1]) == adjlist.end()){
                      adjlist[arr[1]].push_back(arr[0]);
                }
              else{
                    adjlist[arr[1]].push_back(arr[0]);
              }

            }

         
            

          
        queue<int> q;
            int count = 0;
        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.push(i);
                count++;
            }
        }
       

        while(!q.empty()){
            int front = q.front();
            q.pop();
            for(auto i: adjlist[front]){
               indegree[i]--;
               if( indegree[i] == 0){
                   q.push(i);
                   count++;
                if(count == numCourses){
                    return true;
                }
               }
            }
        }

        return false;
    }
};