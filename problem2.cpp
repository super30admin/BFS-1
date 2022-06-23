
// Time Complexity : O(V+E) 
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
public:
    
    void hasCycle( int pass, unordered_map<int,vector<int>> & adjlist,  unordered_map<int,bool>& visitednodes,  bool &flag , unordered_map<int,bool>& checkednodes){
        // DFS
        if( !flag ){
            return;
        }
        if( checkednodes[pass] ) {
            return;
        }
        visitednodes[pass] = true;
        
        vector<int> adjlistvec = adjlist[pass];
        for( int i =0; i<adjlistvec.size(); i++){
               if( visitednodes[adjlistvec[i]] ){
                   flag = false;
                   return;
               }
               hasCycle( adjlistvec[i], adjlist, visitednodes, flag, checkednodes );
        }
        visitednodes[pass] = false;
        checkednodes[pass] = true;
    }
    
    
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int,vector<int>>adjlist;
        
        if( !prerequisites.size()){
            return true;
        }
        
        for( int i=0; i<prerequisites.size(); i++){
            if( adjlist.find(prerequisites[i][1] ) == adjlist.end() ){
                vector<int>temp { prerequisites[i][0]};
                adjlist[prerequisites[i][1]] = temp;
            } else{
                adjlist[prerequisites[i][1]].push_back( prerequisites[i][0] );
            }
        }
        unordered_map<int,bool>visitednodes;
        unordered_map<int,bool>checkednodes;
        bool flag = true;
        //auto it = adjlist.begin();
        
        for( auto it = adjlist.begin(); it != adjlist.end(); it++){
            int pass = it->first;
            if( visitednodes.find( it->first ) == visitednodes.end() ){
                   hasCycle( pass, adjlist, visitednodes, flag, checkednodes );
                   if ( !flag ){
                       break;
                   }
            }
         
        }
        return flag;
    }
};
