//TC: O( e + v) where e is number of edges, v is vertices. We visit each edge and each vertice once.
//SC: O(e + v) (for the hashmap) - asymptotic

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        //in degree vector
        //initialize all values in inDegree to 0

        vector<int> inDegree(numCourses);
        
        
        //adjacency list
        //create map of {parent:{list of children}} since there's no graph structure here.
        unordered_map<int, vector<int>> hashMap;
        
        for(int i=0; i<prerequisites.size(); i++){
            //get each value of the prerequisites vector.
            vector<int> each = prerequisites[i];
            int to = each[1];
            int from  = each[0];
            
            //increment indegree index of the "to" node. Since inDegree vector is vector of how many edges are entering a particular node.
            inDegree[to]++;
            
            //add this value to the hashmap
            hashMap[from].push_back(to);               
        }
        
        //to traverse this graph.
        queue<int> q;
        
        
        for(int x = 0; x<numCourses; x++){
            //set starting point of the traversal as nodes that do not have any incoming nodes (something like a root value)
            if(inDegree[x] == 0){
                q.push(x);
            }
        }
        
        
        
        //done to traverse the tree in a level order fashion.
        while(!q.empty()){
            int front = q.front();
            q.pop();
            
            //finding all the children of that node
            if(hashMap.find(front)!=hashMap.end()){
                vector<int> toList = hashMap[front];
                for(int x = 0; x<toList.size(); x++){
                    //decrementing that edge of the parent to child
                    inDegree[toList[x]]--;
                    //only if this is equal to 0 (free of any loop), add to queue
                    if(inDegree[toList[x]] == 0){
                        q.push(toList[x]);
                    }
                }
                
            }
            
        }
        
        
        //check if any indegree is not 0. If any one is not zero, then that node has a loop. Cannot take the courses in the list.
        for(int i=0; i<inDegree.size(); i++){
            if(inDegree[i]!=0)
                return false;
        }
    
        
        return true;
        
        
    }
};