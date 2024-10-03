// time: O(V+E)
// space: O(V)
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        int count = 0; // courses completed
        vector<int> vec(numCourses); // num of prereqs left for each course, course(index):prereq
        unordered_map<int,vector<int>> umap; // prereq:courses
        for(auto i : prerequisites) {
            vec[i[0]]++;
            umap[i[1]].push_back(i[0]);
        }
        queue<int> indep; // courses without any prereqs
        for(int i = 0; i < vec.size(); i++) {
            if(vec[i] == 0) {
                indep.push(i);
                count++;
            }
        }
        while(!indep.empty()) {
            int curr = indep.front();
            indep.pop();
            for(int i : umap[curr]) {
                vec[i]--;
                if(vec[i] == 0) {
                    indep.push(i);
                    count++;
                }
                // if(count == numCourses) {
                //     return true;
                // }
            }
            if(count == numCourses) {
                return true;
            }
        }
        return false;
    }
};