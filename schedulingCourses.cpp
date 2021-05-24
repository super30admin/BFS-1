/*
Intuition: Make an adjacency list. Always start with the independent nodes. 

Keep decreasing the independcy of the course to check if a cycle exists or not
BFS Solution
Time Complexity: O(V+E) where Vertices = V and E = Edges
Space Complexity: O(N) where Vertices = V and E = Edges
*/

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        int independencies[numCourses];
        map <int, vector<int>> map;
        for ( int i =0; i < numCourses; i++){
            independencies[i] = 0;
            
        }
        for (auto edge: prerequisites){
            
            int curr = edge[0];
            int pre = edge[1];
            if (map.find(pre) == map.end()){
                vector<int> newArray;
                newArray.push_back(curr);
                map[pre] = newArray; 
                
            }
            else{
                map[pre].push_back(curr);
            }
            independencies[curr] += 1;
        }
        queue <int> queue;
        for ( int i =0; i < numCourses; i++){
            cout << independencies[i]<< " ";
            
        }
        cout << endl;
        
        
        for ( int i =0; i < numCourses; i++){
            if (independencies[i] == 0){
                queue.push(i);
            }
        }
        
        if ( queue.size()== 0) return false;
        
        
        while ( queue.size()!= 0){
            
            int currentNode = queue.front();
            queue.pop();
            for ( auto childCourse : map[currentNode]){
                independencies[childCourse]--;
                if (independencies[childCourse] == 0){
                    queue.push(childCourse);
                }
            
            }
        }
        
        for ( int i =0; i < numCourses; i++){
            if (independencies[i] > 0){
                return false;
            }
        }
      return true;  
    }
};