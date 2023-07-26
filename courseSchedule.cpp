class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.size()==0){
            return true;
        }
        unordered_map<int ,vector<int>> map;
        vector<int> inDegrees(numCourses);

        for(auto x:prerequisites){
            inDegrees[x[0]]++;


            if(map.find(x[1])==map.end()){

                map[x[1]]={};
                map[x[1]].push_back(x[0]);

            }
            else{
                map[x[1]].push_back(x[0]);
            }      
            
        }

        queue<int> q;
        int count=0;
        
            for(int i:inDegrees){
                if(i==0){
                    q.push(i);
                    count++;
                }
            }

            
        

        if(q.empty()){
            return false;
        }
        while(!q.empty()){
            int curr = q.front();
            q.pop();
            vector<int> li = map[curr];
        
            if(li.size()==0){
            
            for(int child:li){

                inDegrees[child]--;
                if(inDegrees[child]==0){
                    q.push(child);
                    count++;
                    if(count==numCourses){
                        return true;
                    }
                    

                }


            }
        }

        

    }

    return false;
    







    

         






        
    }
};