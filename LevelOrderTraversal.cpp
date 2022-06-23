// Approach 1 - BFS
// Time Complexity - O(n), since we are processing a total of 'n' nodes in the input tree.
// Space Complexity - O(n), since at max we can have a total of 'n/2' elements in the queue.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> answer;
        
        if(root == NULL) return answer;
        
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty()){
            int size = q.size();
            vector<int> level;
            for(int i = 0; i < size; i++){
                TreeNode* curr = q.front(); q.pop();
                level.push_back(curr->val);
                if(curr->left)
                    q.push(curr->left);
                if(curr->right)
                    q.push(curr->right);
            }
            answer.push_back(level);
        }
        return answer;
    }
};


// Approach 2 - DFS
// Time Complexity - O(n), since we are processing a total of 'n' nodes in the input tree.
// Space Complexity - O(1), since we are not using any extra space. (Auxiliary Space -> O(h), h is the height of the tree)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<vector<int>> answer;
    private:
    void dfs(TreeNode* root, int lvl){
        //base
        if(root == NULL) return;
        //logic
        if(answer.size() == lvl){
            vector<int> newV;
            answer.push_back(newV);
        }
        answer[lvl].push_back(root->val);
        dfs(root->left, lvl+1);
        dfs(root->right, lvl+1);
    }
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        dfs(root,0);
        return answer;
    }
};