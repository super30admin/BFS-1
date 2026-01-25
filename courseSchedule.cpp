class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> inorder(numCourses, 0);
        unordered_map<int, vector<int>> um;

        for (vector<int> courses : prerequisites) {
            um[courses[1]].push_back(courses[0]);
            inorder[courses[0]]++;
        }

        queue<int> q;

        for (int i=0;i<inorder.size();i++) {
            if (inorder[i] == 0) {
                q.push(i);
            }
        }

        int count = 0;

        while (!q.empty()) {
            int node = q.front();
            count++;
            q.pop();

            for (auto itr: um[node]){
                inorder[itr]--;
                if (inorder[itr] == 0) {
                    q.push(itr);
                }
            } 
        }

        return count == numCourses;

    }
};
